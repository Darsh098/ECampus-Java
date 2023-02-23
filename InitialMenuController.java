//package controller;
//import InitialMenuView;
public class InitialMenuController {

    //this controllers member function is used to handle users initial menu choice
    //this member function calls the initial menu view.
    //gets user input
    //and based on users input calls the other controllers.
    public static int initialMenu() {
        //get choice from console.
        int choice = InitialMenuView.initalMenu();
        switch (choice){
            //if user selects 1) which is for login
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return LoginController.loginMenu();
            //if user selects 2) which is for signup
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return RegisterController.registerUser();
            //if user select 3) which is for exit
            case 3: return 0;
            default:return -1;
        }
    }
}
