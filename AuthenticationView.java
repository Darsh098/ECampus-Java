//package views;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class AuthenticationView {
    //gets user's username and password
    //this member function display a view to the user on the console
    //promoting to enter username and password
    //further this member function generates an array list of string
    //which at index 0 contains username and at index 1 contains password
    //and then returns the array list of string
    public static ArrayList<String> authenticationView(){
        Scanner scan = new Scanner(System.in);
        Console console = System.console();
        
        
        System.out.println("\n=======================================");
        System.out.print("\nEnter username: ");
        String username = scan.next();
        System.out.print("Enter password: ");
        String password;
        if(console!=null){
            password = new String(console.readPassword());
            for(int i=0;i<password.length();i++){System.out.print("*");}
            System.out.println("");
        }
        else password = scan.next();
        
        System.out.println("\n=======================================");
        
        ArrayList<String> creds = new ArrayList<String>();
        creds.add(username);
        creds.add(password);
        return creds;
    }
}
