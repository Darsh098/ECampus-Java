public class CourseScore {
    private Course course;
    private int obtainedMarks;
    private char grade;
    private int attainedCredits;

    public CourseScore(Course course, int obtainedMarks, char grade, int attainedCredits) {
        this.course = course;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
        this.attainedCredits = attainedCredits;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getAttainedCredits() {
        return attainedCredits;
    }

    public void setAttainedCredits(int attainedCredits) {
        this.attainedCredits = attainedCredits;
    }
}