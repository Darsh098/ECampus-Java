public class CourseScore {
    private Course course;
    private int obtainedMarks;
    private String grade;
    private int attainedCredits;

    public CourseScore(Course course, int obtainedMarks, String grade, int attainedCredits) {
        this.course = course;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAttainedCredits() {
        return attainedCredits;
    }

    public void setAttainedCredits(int attainedCredits) {
        this.attainedCredits = attainedCredits;
    }
}