//package views;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationView {
    //this view's meber function is used to displaya registration form on the console.
    public static ArrayList<String> registrationView(){
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
        
        System.out.print("Enter password again: ");
        String confPassword;
        if(console!=null){
            confPassword = new String(console.readPassword());
            for(int i=0;i<password.length();i++){System.out.print("*");}
            System.out.println("");
        }
        else confPassword = scan.next();
        System.out.println("\n=======================================");
        
        ArrayList<String> details = new ArrayList<String>();
        details.add(username);
        details.add(password);
        details.add(confPassword);
        return details;
    }
}
