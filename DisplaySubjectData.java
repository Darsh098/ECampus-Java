//package views;

//import Subject;

import java.util.ArrayList;

//this is view class
//used to display subject details
public class DisplaySubjectData {
    //this member function is used to display percentage
    public static void displayMarks(String message,double percentage) {
        System.out.print(message + " : " + percentage);
    }
    //this member function is used to display grade and status
    public static void displayMarks(String message,String grade) {
        System.out.print(message + " : " + grade);
    }

    //this member function is used to display subjects' detail
    public static void displaySubjects(ArrayList<Subject> subjects,String name){
        System.out.println("\n=======================================");
        System.out.println("Student ID: "+name);
        System.out.println("Subject details: ");
        for(int i=0;i<subjects.size();i++){
            System.out.println("-------------------------------------");
            System.out.println("Subject name: "+subjects.get(i).getName());
            System.out.println("Subject marks: "+
                    subjects.get(i).getMarks_obtained()+" / "+
                    subjects.get(1).getMarks_total()
            );
        }
        System.out.println("=======================================");
    }
}
