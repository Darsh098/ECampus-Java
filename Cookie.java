//package helper;

//this class is used in the project as cookie storage
public class Cookie {
    //data member to store username as cookie
    //has to be static as it is used across different class's member functions
    private static String userCookie;

    //cookie getter
    public static String getUserCookie(){
        return userCookie;
    }
    //cookie setter
    public static void setUserCookie(String username){
        userCookie= username;
    }
}
