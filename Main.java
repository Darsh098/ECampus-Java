import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        UserHelper obj = new UserHelper();
        while(true)
        {
            System.out.println("\n=============================");
            System.out.println("********* E Campus *********");
            System.out.println("=============================");
            System.out.println("1. Registration ");
            System.out.println("2. Sign In ");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice: ");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    obj.RegisterUser();
                    break;
                case 2:
                    obj.SignIn();
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Selection :");
                    break;
            }
        }
    }
}
