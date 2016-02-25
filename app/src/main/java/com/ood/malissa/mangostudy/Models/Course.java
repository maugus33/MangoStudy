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
public class Course
{
    private int CRN;
    private String name;
    private Professor prof;
    private ArrayList<TA> TAs;
    private ArrayList<Student> students;
    private StudyGroup classChat;
    private ArrayList<StudyGroup> groups;
    
    public Course(int crn, String Name, Professor Prof)
    {
        CRN = crn;
        name = Name;
        prof = Prof;
        TAs = new ArrayList();
        students = new ArrayList();
        groups = new ArrayList();
        this.addStudyGroup(this.getName());
        classChat = groups.get(0);
    }
    
    public Course(int crn, String Name, Professor Prof, ArrayList<TA> ta)
    {
        CRN = crn;
        name = Name;
        prof = Prof;
        TAs = new ArrayList();
        students = new ArrayList();
        TAs.addAll(ta);
        groups = new ArrayList();
        this.addStudyGroup(this.getName());
        classChat = groups.get(0);
    }
    
    public void EmailProfessor(Student student, String email)
    {
        Message message = new Message(student.getName(),email);
        prof.receveMail(message);
    }
    
    public void EmailTAs(Student student, String email)
    {
        Message message = new Message(student.getName(),email);
        for(TA t:TAs)
        {
            t.receveMail(message);
        }
    }
    
    public void addStudent(Student student)
    {
        student.addClass(this);
        students.add(student);
        classChat.addStudent(student);
    }
    
    public void addStudyGroup(String name)
    {
        groups.add(new StudyGroup(this,name));
    }
    
    public StudyGroup getStudyGroup()
    {
        return classChat;
    }

    public int getCRN()
    {
        return CRN;
    }

    public String getName()
    {
        return name;
    }

    public Professor getProf()
    {
        return prof;
    }
    
    public StudyGroup findStudyGroup(String groupName)
    {
        StudyGroup sg = null;
        for(StudyGroup sg1:groups)
        {
            if(sg1.getName()==groupName)
            {
                sg = sg1;
                break;
            }
        }
        return sg;
    }
}
