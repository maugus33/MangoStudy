/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ood.malissa.mangostudy.Models;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Student implements User
{
    private final String name;
    private final String email;
    private final String userName;
    private final String password;
    private MessageBox messageBox;
    private ArrayList<Course> classes;
    private Course curStudying;
    private ArrayList<StudyGroup> studyGroups;
    
    public Student(String Name, String Email, String UserName, String Password)
    {
        name = Name;
        email = Email;
        userName = UserName;
        password = Password;
        messageBox = new MessageBox();
        classes = new ArrayList();
        studyGroups = new ArrayList();
//        classes.add(new Course(0,"None",null));
//        curStudying = classes.get(0);
        curStudying = null;
    }
    
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getUserName()
    {
        return userName;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public void addClass(Course section)
    {
        classes.add(section);
    }
    
    @Override
    public String viewMessages()
    {
        return messageBox.viewMessages();
    }
    
    public String viewMessages(String groupName)
    {
        StudyGroup sg = null;
        for(StudyGroup sg1:studyGroups)
        {
            if(sg1.getName() == groupName)
            {
                sg = sg1;
                break;
            }
        }
        return sg.viewMessages();
    }
    
    @Override
    public void sendMessage(String text, StudyGroup group)
    {
        Message m = new Message(this.name,text);
        group.sendMessage(m);
    }
    
    @Override
    public String identify()
    {
        return "Student";
    }
    
    public void createStudyGroiup(Course course, String name)
    {
        StudyGroup g = new StudyGroup(course, name);
        studyGroups.add(g);
        joinStudyGroup(g);
    }
    
    public void joinStudyGroup(StudyGroup sg)
    {
        studyGroups.add(sg);
    }
    
    public Course getCourse(int crn)
    {
        for(Course c:classes)
        {
            if(c.getCRN() == crn)
            {
                return c;
            }
        }
        return null;
    }
    
    public Course getCurrentlyStudying()
    {
        return curStudying;
    }
    
    public void setStudying(int CRN)
    {
        curStudying = this.getCourse(CRN);
    }
    
    public void sendStudyGroupMessage(String studyGroupName, String message)
    {
        StudyGroup sg = null;
        for(StudyGroup sg1:studyGroups)
        {
            if(sg1.getName() == studyGroupName)
            {
                sg = sg1;
                break;
            }
        }
        if(sg != null)
        {
            Message m = new Message(name,message);
            sg.sendMessage(m);
        }
    }
    
    public void joinStudyGroup(String groupName)
    {
        studyGroups.add(curStudying.findStudyGroup(groupName));
    }
    
//    public void createStudyGroup(String name, Course subject)
//    {
//        StudyGroup s = new StudyGroup(name, subject);
//        studyGroups.add(s);
//    }
}
