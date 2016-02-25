package com.ood.malissa.mangostudy.Controllers;

import android.widget.Toast;

/**
 * Created by Malissa on 2/25/2016.
 * Object in charge of collaborating between the various different activities
 * and models
 */
public class Collaborator {
    private Collaborator(){}//only one instance of collaborator

    /**
     * A function that calls verifyAccount then calls the function that
     * sets up BrowseList if the account is verified.
     * @param username a String that is the username used to log in
     * @param pass a String that is the password used to log in
     * @param isSeller a boolean that determines if the  user is a seller
     * @author Paul Benedict Reyes
     *
     */
    //framework for login
    /*public void login(String username, String pass, boolean isSeller) {

        if(verifyAccount(username, pass, isSeller)) {

            //login user
            setUser();

        }
        else
        {
            // post toast
            Toast.makeText(Login.getAppContext(), "Invalid username or password.",
                    Toast.LENGTH_LONG).show();
        }
    }*/

    /**
     * Used to set which user logged in and call setup function for that user
     * removed use of the usertype.
     * @author Malissa Augustin
     * example of how to open a new activity
     */
    /*private void setUser(){
        Intent i = new Intent(Login.getAppContext(), BrowseList.class);
        i.putExtra("User", this._user);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Login.getAppContext().startActivity(i);
    }*/

}
