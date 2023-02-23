//package controller;

//import helper.Cookie;
//import helper.StudentDetailReturn;
//import models.DataHelper;
//import views.DisplaySubjectData;
//import views.GetStudentDataView;

import java.util.InputMismatchException;

public class UpdateStudentDetails {
    //this controller's member function is used to update student's details regarding thier name , studentid and subjects
    public static boolean update()throws InputMismatchException{
        try {
            StudentDetailReturn data = GetStudentDataView.getStudentDetails();
            if (data == null) throw new InputMismatchException();
            DataHelper.setStudentData(Cookie.getUserCookie(), data.getStudentId(), data.getSubjects(),data.getFirst_name(),data.getLast_name());
            DisplaySubjectData.displaySubjects(data.getSubjects(),data.getStudentId());
            return true;
        }catch(Exception e){
            System.out.println("Invalid Input.");
            return false;
        }
    }
}
