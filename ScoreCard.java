import java.util.ArrayList;

public class ScoreCard {
    private Student student;
    private ArrayList<CourseScore> courseScores;
    private double overallGrade;
    private double percentile;

    public ScoreCard(Student student) {
        this.student = student;
        this.courseScores = new ArrayList<>();
    }

    public void addCourseScore(CourseScore courseScore) {
        courseScores.add(courseScore);
    }

    public void removeCourseScore(CourseScore courseScore) {
        courseScores.remove(courseScore);
    }

    public ArrayList<CourseScore> getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(ArrayList<CourseScore> courseScores) {
        this.courseScores = courseScores;
    }

    public double getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(double overallGrade) {
        this.overallGrade = overallGrade;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }
}
