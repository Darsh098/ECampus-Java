//import InitialMenuController;
//import DataHelper;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//test

public class Main {

    //main function which initializes the emulated database of the project
    //and also displays the initial view to the user.
    public static void main(String[] args){
        //initialise database using static method;
        DataHelper.initialiDataHelper();
        int status = -1;
        while(status==-1){
            status=InitialMenuController.initialMenu();
        }
        if(status==0) {
            System.out.println("Exiting...");
            System.exit(0);
        }
//        test1();
    }
    public static void test1(){
        Scanner scan = new Scanner(System.in);
        Console console = System.console();
//        Scanner scanner = new Scanner(System.in);
        String pass;
        if(console!=null) {
            pass = new String(console.readPassword());
            System.out.println(pass);
        }
        else{
            pass = scan.next();
            System.out.println(pass);
        }
    }
}
