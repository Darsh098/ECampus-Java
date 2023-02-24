import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserHelp {

        Scanner sc=new Scanner(System.in);
        int choice;
        String fullname,username,password,cnfpassword;
        ArrayList<User> Userlist=new ArrayList<>();

        void Registration()
        {
            System.out.println("\n=============================");
            System.out.println("********* Registration *********");
            System.out.println("\n=============================");
            while (true)
            {
                System.out.println("Enter Full Name :");
                fullname=sc.nextLine();
                //validation to check length
                if(fullname.length()==0)
                {
                    System.out.println("Name cannot be Blank ");
                }
                else if(!Pattern.matches("[a-zA-Z]{"+fullname.length()+"}",fullname))
                {
                    System.out.println("Name Must Contain only Characters");
                }
                else
                {
                    break;
                }
            }

            //loop for username;
            while(true)
            {
                System.out.println("Enter Username :");
                username=sc.nextLine();
                if(username.length()==0)
                {
                    System.out.println("user name cannot be empty");
                }
                else
                {
                    break;
                }
            }

            while(true)
            {
                System.out.println("Enter Password :");
                password=new String(System.console().readPassword());
                for (int i=0;i<password.length();i++)
                {
                    System.out.print("*");
                }
                System.out.println("\n");
                if(password.length()>=8)
                {
                    break;
                }
                else
                {
                    System.out.println("\n Password must contain Atleast 8 character");
                }
            }
            System.out.println("Confirm Password :");
            cnfpassword=new String(System.console().readPassword());
            for (int i=0;i<password.length();i++)
            {
                System.out.print("*");
            }

            if(password.equals(cnfpassword))
            {
                User u=new User(fullname,username,password);
                Userlist.add(u);
                System.out.println("\n\n Registration Successfull");
            }
            else
            {
                System.out.println("\n Both Password must be Same");
                Registration();
            }
        }

        void SignIn()
        {
            System.out.println("\n=============================");
            System.out.println("********* Sign  *********");
            System.out.println("\n=============================");
            while(true)
            {
                System.out.println("\n Enter UserName : ");
                username=sc.nextLine();
                if (username.length()==0)
                {
                    System.out.println("username cannot be Blank");
                }
                else
                {
                    break;
                }
            }
            System.out.println("Enter Your Password :");
            password=new String(System.console().readPassword());
            for(int i=0;i<password.length();i++)
            {
                System.out.print("*");
            }
            System.out.println();
            User u=null;
            int index=-1;
            for (User user:Userlist)
            {
                index++;
                if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
                {
                    u=user;
                    break;
                }
            }
            if(u!=null)
            {
                System.out.println("\n Welcome "+u.getUsername());
            }
            else
            {
                System.out.println("\n Incorrect Password ");
                while (true)
                {
                    System.out.println("1, Try Again ");
                    System.out.println("2. Forget Password ");
                    System.out.println("0. Home");
                    System.out.println("\n Enter Your Choice :");
                    choice=sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            SignIn();
                            break;
                        case  2:
                            forgetpasswd();break;
                        case 0:
                            sc.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Enter Valid Option");
                    }
                }
            }
        }

        void forgetpasswd()
        {
            User u=null;
            while (true)
            {
                u=null;
                System.out.println("\nEnter Fullname :");
                fullname=sc.nextLine();
                for (User user:Userlist)
                {
                    if(fullname.equals(user.getFullname()))
                    {
                        u=user;
                        break;
                    }
                }
                if(u!=null)
                {
                    while (true)
                    {
                        System.out.println("\nEnter Password :");
                        password=new String(System.console().readPassword());
                        for(int i=0;i<password.length();i++)
                        {
                            System.out.print("*");
                        }
                        if(password.length()>=8)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("\n password must contain Atleast 8 charactes");
                        }
                    }
                    System.out.println();
                    System.out.println("\n\nConfirm Password :");
                    cnfpassword=new String(System.console().readPassword());
                    for (int i=0;i<cnfpassword.length();i++)
                    {
                        System.out.println("*");
                    }
                    if (password.equals(cnfpassword))
                    {
                        u.setPassword(password);
                        System.out.println("\n Password changes Successfully");
                        break;
                    }
                    else
                    {
                        System.out.println("\n\n Both password must be same");
                        sc.nextLine();
                    }
                }
                else
                {
                    System.out.println("\n User not Found \n");
                }
            }
        }



}
