//package controller;

import java.util.ArrayList;

//import models.DataHelper;
//import views.RegistrationView;

public class RegisterController {

    //this controller's member function is use to call the registration view
    //it get the registration details and registers a user in the emulated database if any user does not exist
    // with the same username
    public static int registerUser(){
        ArrayList<String> details = RegistrationView.registrationView();

        if(! details.get(1).equals(details.get(2))){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Passwords do not match!");
            return -1;
        }
        else if(DataHelper.usernameExists(details.get(0))){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Username already in use. Enter different username.");
            return -1;
        }else{
            DataHelper.registerStudent(details.get(0),details.get(1));
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("User Registered.");
        }
        return -1;
    }
}
