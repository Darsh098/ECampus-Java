//import Cookie;
//import DataHelper;
//import ForgotPasswordView;
//import LoginView;
public class LoginController {

    //this controllers member function is used to handle users choice on the login view.
    //this member function authenticates the user.
    //helps user in case they forget the password.
    //also provides the option to go to the initial view.

    private static int handleChoice(int choice){
        switch (choice){
            //1) is to enter login details
            case 1: {
                boolean loggedIn = LoginDetailsController.authenticate();
                if(!loggedIn) {loginMenu(); return -1;}
                if(!DataHelper.studentHasData(Cookie.getUserCookie())){
                    boolean c = false;
                    while(!c) {
                        c = UpdateStudentDetails.update();
                    }
                    DataHelper.setStudentHasData(Cookie.getUserCookie());
                }
                //show marks operations
                int c = 0;
                while(c==0) {
                    c =  DisplaySubjectDataController.display();
                }
                if(c==-1) return loginMenu();
                return 0;
            }
            //2) is if user forgets the password
            case 2:{
                String username = ForgotPasswordView.getUsername();
                String newPassword = DataHelper.setNewPassword(username);
                if(newPassword==null){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("No user Found!");
                    return loginMenu();}
                else ForgotPasswordView.showPassword(newPassword);
                return -1;
            }
            //3) to exit
            case 3:return -1;
            default:return -1;
        }
    }

    //this function is used to display login menu view to the user.
    //continues to call login menu if the input is invalid.
    //once it receives valid input it further calls handleChoice function
    public static int loginMenu(){
        Cookie.setUserCookie("");
        //getting user's choice from console
        int choice = -1;
        while(choice == -1){
            choice = LoginView.loginMenu();
        }

        return handleChoice(choice);
    }
}
