//package controller;

//import Cookie;
//import DataHelper;
//import Subject;
//import DisplaySubjectData;
//import SelectSubjectDisplay;

import java.util.ArrayList;

public class DisplaySubjectDataController {
    public static int display(){
        //calls view and stores what the view has returned
        int input = SelectSubjectDisplay.display();
        if(input == -1) return 0;
        switch (input){
            //1 is when user asks to get percentage of subjects
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                handlePercentageCalculation();return 0;
            //2 is when user asks to calculate grade
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                handleGradeCalculation();
                return 0;
            //3 is when user asks to calculate status
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                handleStatusCalculation();
                return 0;
            //4 is when user display subject details
            case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                handleSubjectDisplay();
                return 0;
            //5 is when user want to logout
            case 5:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return -1;
            default:return 1;
        }
    }

    //this member function handles status calculation
    private static void handleStatusCalculation(){
        String string = getGrade();
        String studentName = DataHelper.getStudentName(Cookie.getUserCookie());
        String message = "Status of student "+studentName;
        String status="Pass";
        if(string=="F") status = "Fail";
        DisplaySubjectData.displayMarks(message,status);
    }

    //this member function handles grade calculation
    private static void handleGradeCalculation(){
        String grade = getGrade();
        String studentName = DataHelper.getStudentName(Cookie.getUserCookie());
        String message = "Grade of student "+studentName;
        DisplaySubjectData.displayMarks(message,grade);
    }

    //this member function return grade of the logged in student
    public static String getGrade(){
        String grade="";
        double percentage = getPercentage();
        if(percentage<=100.0 && percentage>=90.0) grade = "AA";
        else if(percentage<=89.0 && percentage>=80.0) grade = "AB";
        else if(percentage<=79.0 && percentage>=70.0) grade = "BB";
        else if(percentage<=69.0 && percentage>=60.0) grade = "BC";
        else if(percentage<=59.0 && percentage>=50.0) grade = "CC";
        else if(percentage<=49.0 && percentage>=40.0) grade = "CD";
        else grade = "F";
        return grade;
    }

    //this member function hadles percentage calculation
    public static void handlePercentageCalculation(){
        double percentage = getPercentage();
        String studentName = DataHelper.getStudentName(Cookie.getUserCookie());
        String message = "Percentage of student "+studentName;
        DisplaySubjectData.displayMarks(message,percentage);
    }

    //this member function return percentage if the logged in student
    public static double getPercentage(){
        final ArrayList<Subject> subjects = DataHelper.getSubjects(Cookie.getUserCookie());
        double percentage=0.0;
        for(int i=0;i<subjects.size();i++){
            double marks = subjects.get(i).getMarks_obtained();
            double total = subjects.get(i).getMarks_total();
            percentage += marks/total * 100;
        }
        percentage/=subjects.size();
        return percentage;
    }

    //this member fucntion hadles subject display for the logged in student
    public static void handleSubjectDisplay(){
        final ArrayList<Subject> subjects = DataHelper.getSubjects(Cookie.getUserCookie());
        String name = DataHelper.getStudentName(Cookie.getUserCookie());
        DisplaySubjectData.displaySubjects(subjects,name);
    }
}
