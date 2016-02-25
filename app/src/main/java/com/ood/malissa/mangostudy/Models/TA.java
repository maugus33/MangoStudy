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
public class TA extends Professor
{

    public TA(String Name, String Email, String UserName, String Password, String OfficeHours)
    {
        super(Name, Email, UserName, Password, OfficeHours);
    }
    
    @Override
    public String identify()
    {
        return "TA";
    }
}
