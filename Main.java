import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        UserHelp ecampus=new UserHelp();
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true)
        {
            System.out.println("\n=============================");
            System.out.println("********* E Campus *********");
            System.out.println("\n=============================");
            System.out.println("1. Registration ");
            System.out.println("2. Sign In ");
            System.out.println("3. Forget Password");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice: ");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    ecampus.Registration();
                    break;
                case 2:
                    ecampus.SignIn();
                    break;
                case 3:
                    ecampus.forgetpasswd();
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
