/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ood.malissa.mangostudy.Controllers;

import com.ood.malissa.mangostudy.Models.Course;
import com.ood.malissa.mangostudy.Models.Professor;
import com.ood.malissa.mangostudy.Models.Room;
import com.ood.malissa.mangostudy.Models.Student;
import com.ood.malissa.mangostudy.Models.TA;
import com.ood.malissa.mangostudy.Models.User;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class MainSystem
{
    private ArrayList<User> users;
    private User curUser;
//    private ArrayList<Student> students;
//    private ArrayList<Professor> professors;
    private ArrayList<TA> TAs;
    private ArrayList<Course> courses;
    private ArrayList<Room> rooms;
    private ArrayList<Room> availableRooms;
    
    public MainSystem()
    {
        users = new ArrayList();
        curUser = null;
//        students = new ArrayList();
//        professors = new ArrayList();
        TAs = new ArrayList();
        courses = new ArrayList();
        rooms = new ArrayList();
        availableRooms = new ArrayList();
    }
    
    public void addStudent(String name, String email, String userName, String password)
    {
        Student s = new Student(name, email, userName, password);
        users.add(s);
//        students.add(s);
    }
    
    public void addProfessor(String name, String email, String userName, String password, String officeHours)
    {
        Professor p = new Professor(name, email, userName, password, officeHours);
        users.add(p);
    }
    
    public void addTA(String name, String email, String userName, String password, String officeHours)
    {
        TA t = new TA(name, email, userName, password, officeHours);
        users.add(t);
    }
    
    public void addCourse(int CRN, String name)
    {
        if(curUser.identify() == "Professor")
        {
            Course c = new Course(CRN, name, (Professor) curUser);
            courses.add(c);
        }
    }
    
    public void addRoom(String building, String floor, String name)
    {
        Room r = new Room(building, floor, name);
        rooms.add(r);
        availableRooms.add(r);
    }
    
    public void makeRoomAvailable(Room room)
    {
        room.makeAvailable();
        if(!(availableRooms.contains(room)))
        {
            availableRooms.add(room);
        }
    }
    
    public void makeRoomUnvailable(Room room)
    {
        room.makeUnavailable();
        if(availableRooms.contains(room))
        {
            availableRooms.remove(room);
        }
    }
    
    public void registerStudentForClass(int crn)
    {
        if(curUser.identify() == "Student")
        {
            Course course = null;
            for(Course c:courses)
            {
                if(c.getCRN() == crn)
                {
                    course = c;
                    break;
                }
            }
            if(!(course == null))
            {
                course.addStudent((Student) curUser);
            }
        }
    }
    
    public void logIn(String username, String password)
    {
        for(User u : users)
        {
            if((username.equals(u.getUserName())) && (password.equals(u.getPassword())))
            {
                curUser = u;
            }
        }
    }
    
    public ArrayList<Room> getAvailableRooms()
    {
        return availableRooms;
    }
    
    public void emailProfessor(Course course, String message)
    {
        if(curUser.identify() == "Student")
        {
            course.EmailProfessor((Student) curUser, message);
        }
    }
    
    public void selectClass(int CRN)
    {
        ((Student)curUser).setStudying(CRN);
    }
    
    public void addStudyGroup(String name)
    {
        if(curUser.identify() == "Student")
        {
            ((Student)curUser).getCurrentlyStudying().addStudyGroup(name);
            ((Student)curUser).joinStudyGroup(name);
        } 
    }
    
    public void sendStudyGroupMessage(String name, String message)
    {
        if(curUser.identify() == "Student")
        {
            ((Student)curUser).sendStudyGroupMessage(name, message);
        }
    }
    
    public String viewGroupMessages(String groupName)
    {
        return ((Student)curUser).viewMessages(groupName);
    }
    
    public void joinStudyGroup(String groupName)
    {
        ((Student)curUser).joinStudyGroup(groupName);
    }
    
    
    public static void main(String[] args)
    {
        int crn = 1234;
        MainSystem m = new MainSystem();
        m.addStudent("Eduardo", "ed@fau.edu", "ed", "mes");
        m.addStudent("Nacho Mama", "ed@fau.edu", "nacho", "mama");
        m.addProfessor("Professor", "prof@fau.edu", "prof", "essor", "all day ery day");
        m.logIn("ed", "mes");
        System.out.println(m.curUser.getName());
        m.logIn("prof", "essor");
        System.out.println(m.curUser.getName());
        
        m.addCourse(crn, "Java");
        m.logIn("ed", "mes");
        m.registerStudentForClass(crn);
        m.emailProfessor(((Student)m.curUser).getCourse(crn),"hi");
        m.emailProfessor(((Student)m.curUser).getCourse(crn),"how are you?");
        m.logIn("nacho", "mama");
        m.registerStudentForClass(crn);
        m.selectClass(crn);
        m.emailProfessor(((Student)m.curUser).getCourse(crn),"I don't like the way you profess!");
        m.addStudyGroup("I don't like this class");
        m.sendStudyGroupMessage("I don't like this class","I really don't like this class");
        
        m.logIn("prof", "essor");
        System.out.println("Messages to the professor:");
        System.out.println(m.curUser.viewMessages());
        
        m.logIn("ed", "mes");
        m.selectClass(crn);
        m.joinStudyGroup("I don't like this class");
        System.out.println(m.viewGroupMessages("I don't like this class"));
        
        m.sendStudyGroupMessage("I don't like this class","Then why did you sign up for it?");
        m.logIn("nacho", "mama");
        m.selectClass(crn);
        System.out.println(m.viewGroupMessages("I don't like this class"));
    }
}
