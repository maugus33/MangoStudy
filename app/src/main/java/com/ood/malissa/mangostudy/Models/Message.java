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
public class Message
{
    private String sender;
    private String message;
    
    public Message(String Sender, String Message)
    {
        sender = Sender;
        message = Message;
    }
    
    public String getMessage()
    {
        return sender + ":\t" + message;
    }
}
