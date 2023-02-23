//package models;


//this class is used as schema for subject in the emulated database;
public class Subject {
    private String name;
    private double marks_obtained;
    private double marks_total;

    public Subject(String name,double marks_obtained,double marks_total){
        this.name = name;
        this.marks_obtained = marks_obtained;   
        this.marks_total = marks_total;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks_obtained() {
        return marks_obtained;
    }

    public void setMarks_obtained(double marks_obtained) {
        this.marks_obtained = marks_obtained;
    }

    public double getMarks_total() {
        return marks_total;
    }

    public void setMarks_total(double marks_total) {
        this.marks_total = marks_total;
    }
}
