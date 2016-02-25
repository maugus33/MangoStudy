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
public class StudyGroup
{
    private String name;
    private ArrayList<Student> students;
    private Course subject;
    private MessageBox messages;
    
    public StudyGroup(Course Subject, String Name)
    {
        name = Name;
        students = new ArrayList();
        subject = Subject;
        messages = new MessageBox();
    }

    public String getName()
    {
        return name;
    }
    
    public void addStudent(Student student)
    {
        students.add(student);
    }
    
    public void sendMessage(Message mail)
    {
        messages.add(mail);
    }
    
    public String viewMessages()
    {
        return messages.viewMessages();
    }
    
    public boolean contains(Student u)
    {
        return students.contains(u);
    }
}
