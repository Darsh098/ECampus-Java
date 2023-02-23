//package models;

import java.util.ArrayList;
import java.util.HashMap;

//this class is treated as a database for the project
//as well as a Database Object Access(DAO) for the project
public class DataHelper {
    //this data member stores user/student's information
    //it is treated as user/student table of the database if there were any.
    //This data member has to be static as it is used across different classes and object
    //in this project
    private static HashMap<String,Student> studentData = new HashMap<String,Student>();

    //helper member function which is used to created objects of subject class
    //this function is use when the init member function of this class is called
    //to load the dummy data in the studentData data member in this class
    private static ArrayList<Subject> createSubjects(){
        String [] names = {"DSA","Java","MySQL"};
        double [] marks = {90.00,80.00,85.00};
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        for(int i=0;i< 3;i++){
            subjects.add(new Subject(names[i],marks[i],100.00));
        }
        return subjects;
    }
    //this member function is used to create and return Object of student class
    //this is a helper member function thus it is kept as private
    private static Student createStudent(String username,String firstName,String lastname,String student_id){
        String password = "root";
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setStudent_id(student_id);
        student.setFirst_name(firstName);
        student.setLast_name(lastname);
        student.setSubjects(createSubjects());
        return student;
    }
    //this member function has to be called when the main function of the Main class
    //is called. To emulate database like service in the project
    //this member funciton calls other private member functions to create objects of both student class
    //as well as subject class
    public static void initialiDataHelper(){
        if(!studentData.isEmpty()) studentData.clear();
        String [] usernames= {"sidhraj@gmail.com",
                "anurag@gmail.com","himang@gmail.com","aastha@gmail.com"};
        String [] firstNames = {"Sidhraj","Anurag","Himang","Aastha"};
        String [] lastNames = {"Mori","Sharma","Patel","Arora"};
        String [] studentIds = {"101","102","103","104"};

        for(int i=0;i<4;i++){
            Student student = createStudent(usernames[i],firstNames[i],lastNames[i],studentIds[i]);
            student.setHas_data(true);
            studentData.put(student.getUsername(),student);
        }
    }

    //this member function is used to check if user's creadentials are authentic
    //and returns true or false acordingly
    public static boolean authenticate(String username,String password){
        if(studentData.containsKey(username)){
            Student student = studentData.get(username);
            if(student.getPassword().equals(password)){
                return true;
            }
            return false;
        }
        return false;
    }
    //this member function is use to change data of student object that is present in studentData hashmap
    public static void setStudentData(String username,String student_id,ArrayList<Subject> subjects,String first_name,String last_name){
        Student student = studentData.get(username);
        student.setStudent_id(student_id);
        student.setSubjects(subjects);
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        studentData.put(student.getUsername(),student);
    }

    //this member function return arraylist of subject of any perticular student.
    public static final ArrayList<Subject> getSubjects(String username){
        return studentData.get(username).getSubjects();
    }

    //this member fucntion return concatination of first and last name of any student
    public static final String getStudentName(String username){
        Student student = studentData.get(username);
        return student.getFirst_name()+" "+student.getLast_name();
    }

    //this member functions return if the user/student is newly register and does not have student details like
    // student id and subject information along with their marks
    public static final boolean studentHasData(String username){
        return studentData.get(username).isHas_data();
    }

    //this member fucntion is used to register any new user
    //adds that student/user details into the studentData hashmap
    public static void registerStudent(String username,String password){
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setHas_data(false);
        studentData.put(student.getUsername(),student);
    }

    //this member fucntion is used to update or change password
    //of the user. returns null if this fucntion does not find any user with the username provided
    public static String setNewPassword(String username){
        Student student = studentData.get(username);
        if(student==null){
            return null;
        }
        student.setPassword("root");
        return "root";
    }

    //this member fucntion is used to set if the user has entered its student details along with subject details
    public static void setStudentHasData(String username){
        studentData.get(username).setHas_data(true);
    }

    //this member function returns true if the user exists in the database
    public static boolean usernameExists(String username){
        return studentData.containsKey(username);
    }
}