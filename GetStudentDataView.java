//package views;

//import StudentDetailReturn;
//import Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetStudentDataView {
    //this view's member function is used to get student's details from the user
    public static StudentDetailReturn getStudentDetails() throws InputMismatchException {
        try{
            StudentDetailReturn data = new StudentDetailReturn();
            Scanner scan = new Scanner(System.in);
	    
	    System.out.println("\n=======================================");
            System.out.print("\nEnter Student ID: ");
            String studentId = scan.next();

            System.out.print("\nEnter Student first name: ");
            String fname = scan.next();

            System.out.print("\nEnter Student last name: ");
            String lname = scan.next();

            System.out.print("\nEnter number of subjects: ");
            int subjectCount = scan.nextInt();

            ArrayList<Subject> subjects = new ArrayList<Subject>();

            for(int i=0;i<subjectCount;i++){
                System.out.print("\nEnter subject name: ");
                String subjectName = scan.next();
                double marksObtained=0.0;
                while(true){
                    System.out.print("\nEnter marks obtained(0-100): ");
                    marksObtained = scan.nextDouble();
                    if(marksObtained>=0 && marksObtained<=100) break;
                    System.out.println("Invalid Input. Enter between range.");
                }
                subjects.add(new Subject(subjectName,marksObtained,100));
            }
            
            
            System.out.println("\n=======================================");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            data.setStudentId(studentId);
            data.setSubjects(subjects);
            data.setFirst_name(fname);
            data.setLast_name(lname);

            return data;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid Input");
            return null;
        }
    }
}
