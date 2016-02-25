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
public class Room
{
    private final String building;
    private final String floor;
    private final String name;
    private boolean isAvailable;
    
    public Room(String Building, String Floor, String Name)
    {
        building  = Building;
        floor = Floor;
        name = Name;
        isAvailable = true;
    }
    
    public void makeAvailable()
    {
        isAvailable = true;
    }
    
    public void makeUnavailable()
    {
        isAvailable = false;
    }
    
    public String toString()
    {
        return building + ", " + floor + " floor: " + name;
    }
}
