//package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginView {

    //this function displays login menu to the user.
    //this view's member function is used to get the users choice on the login menu.
    public static int loginMenu()throws InputMismatchException{
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("\n=======================================");
            String message = "\n1) Enter Login Details\n2) Forgot password\n3) Go Back";
            System.out.println(message);
            System.out.print("\nEnter your choice: ");
            int input = scan.nextInt();
            System.out.println("\n=======================================");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(input<1 || input>3) throw new InputMismatchException();
            return input;
        }catch(Exception error){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Invalid Input.");
            return -1;
        }
    }
}
