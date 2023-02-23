//package helper;

//import models.Subject;

import java.util.ArrayList;
//this is a helper class which is used as a return object when the user fill thier studentID and subject details on the
//view class's member function
public class StudentDetailReturn {
    private String studentId;
    private String first_name;
    private String last_name;
    private ArrayList<Subject> subjects;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
