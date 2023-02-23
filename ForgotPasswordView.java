//package views;

import java.util.Scanner;

public class ForgotPasswordView {
    //this view's member function is used to get username of the user this then further will be used to
    //change password of the user
    public static String getUsername(){
        Scanner scan = new Scanner(System.in);
        String username;

        System.out.println("\n=======================================");
        System.out.print("\nEnter your username ");
        username = scan.next();
        System.out.println("\n=======================================");
        return username;
    }

    //this view's member function display user's password on the screen
    public static void showPassword(String password){
        System.out.println("\nNew Password: "+password);
    }
}
