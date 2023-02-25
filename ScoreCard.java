import java.util.ArrayList;

public class ScoreCard
{
    private Student student;
    private ArrayList<CourseScore> courseScores;
    private double overallGrade;
    private double percentile;

    public ScoreCard(Student student, ArrayList<CourseScore> courseScores, double overallGrade, double percentile)
    {
        this.student = student;
        this.courseScores = courseScores;
        this.overallGrade = overallGrade;
        this.percentile = percentile;
    }
}
