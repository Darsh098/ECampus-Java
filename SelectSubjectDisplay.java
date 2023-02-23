//package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectSubjectDisplay {
    //this view's member function is used to display menu regarding their subject
    //return int according to input provided by the user
    public static int display()throws InputMismatchException {
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("\n=======================================");
            String message="\n1) Show percentage\n2) Show grades\n3) Show status\n4) Display subject details\n5) Logout";
            System.out.println(message);
            System.out.print("\nEnter your choice: ");
            int input=scan.nextInt();
            System.out.println("\n=======================================");
            return input;
        }catch(Exception e){
            System.out.println("Invalid Input.");
            return -1;
        }
    }
}
