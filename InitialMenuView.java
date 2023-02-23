//package views;
import java.util.InputMismatchException;
import java.util.Scanner;
public class InitialMenuView {

    //this views member function is used to display initial menu to the user and get their choice.

    public static int initalMenu()throws InputMismatchException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n=======================================");
            String message = "\n1) Login\n2) Register\n3) Exit";
            System.out.println(message);
            System.out.print("Enter your choice: ");
            int input = scan.nextInt();
            System.out.println("\n=======================================");
            return input;
        } catch (Exception error) {
            System.out.println("Invalid Input!");
            return -1;
        }
    }
}
