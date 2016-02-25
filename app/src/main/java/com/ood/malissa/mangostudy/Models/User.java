/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ood.malissa.mangostudy.Models;

/**
 *
 * @author Eduardo
 */
public interface User
{
    public String getName();
    public String getEmail();
    public String getUserName();
    public String getPassword();
    public void addClass(Course section);
    public String viewMessages();
    public void sendMessage(String text, StudyGroup group);
    public String identify();
}
