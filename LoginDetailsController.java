
import java.util.ArrayList;

//import DataHelper;
//import AuthenticationView;
//import Cookie;

public class LoginDetailsController {

    //this member function is used to get login credentials from authentication view class.
    //this function also sets the cookie for the user and returns true once the authentication is successful.
    public static boolean authenticate(){
        ArrayList<String> credentials = AuthenticationView.authenticationView();
        if(DataHelper.authenticate(credentials.get(0),credentials.get(1))){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Successful");
            //setting username as cookie to remember the user on the next operation.
            Cookie.setUserCookie(credentials.get(0));
            return true;
        }
        else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Unsuccessful");
            return false;
        }
    }
}
