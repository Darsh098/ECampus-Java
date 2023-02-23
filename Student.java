//package models;

import java.util.ArrayList;

//this class is used as schema for the students in the emulated database;
public class Student {
    private String username;
    private String password;

    private String student_id;
    private String first_name;
    private String last_name;
    private ArrayList<Subject> subjects;
    private boolean is_pass;
    private boolean has_data;

    public boolean isHas_data() {
        return has_data;
    }

    public void setHas_data(boolean has_data) {
        this.has_data = has_data;
    }

    public boolean isIs_pass() {
        return is_pass;
    }

    public void setIs_pass(boolean is_pass) {
        this.is_pass = is_pass;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
