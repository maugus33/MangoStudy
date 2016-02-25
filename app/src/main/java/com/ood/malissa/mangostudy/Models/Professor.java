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
public class Professor implements User
{
    private final String name;
    private final String email;
    private final String userName;
    private final String password;
    private String officeHours;
    private MessageBox messageBox;
    private ArrayList<Course> classes;
    
    public Professor(String Name, String Email, String UserName, String Password, String OfficeHours)
    {
        name = Name;
        email = Email;
        userName = UserName;
        password = Password;
        officeHours = OfficeHours;
        messageBox = new MessageBox();
        classes = new ArrayList();
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
    
    @Override
    public void sendMessage(String text, StudyGroup group)
    {
        Message m = new Message(this.name,text);
        group.sendMessage(m);
    }
    
    @Override
    public String identify()
    {
        return "Professor";
    }
    
    public void receveMail(Message message)
    {
        messageBox.add(message);
    }
}
