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
public class MessageBox
{
    private ArrayList<Message> messages;
    
    public MessageBox()
    {
        messages = new ArrayList();
    }
    
    public void add(Message message)
    {
        messages.add(message);
    }
    
    public String viewMessages()
    {
        String str = "";
        for(Message m:messages)
        {
            str += m.getMessage();
            str += "\n";
        }
        return str;
    }
}
