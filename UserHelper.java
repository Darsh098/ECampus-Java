import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserHelper {
    String fullName, username, password, confirmPassword, courseId, courseName;
    String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
    int credits, totalMarks, passingCriteria, choice;
    Course course = null;
    ArrayList<Student> studentsList = new ArrayList<>();
    ArrayList<Faculty> facultiesList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void RegisterUser() {
        System.out.println("\n============");
        System.out.println("Registration");
        System.out.println("============");
        System.out.println("1. Faculty");
        System.out.println("2. Student");
        System.out.println("Enter Your Choice : ");
        choice = sc.nextInt();

        if (choice < 1 || choice > 2) {
            RegisterUser();
            return;
        }

        // While Loop For Full Name
        sc.nextLine();
        while (true) {
            System.out.println("\nEnter Your Full Name - ");
            fullName = sc.nextLine();

            if (fullName.length() == 0) {
                System.out.println("Name Cannot Be An Empty Field...");
            } else if (!Pattern.matches("[a-zA-Z ]{" + fullName.length() + "}", fullName)) {
                System.out.println("\nName Must Only Contain Characters...");
            } else {
                break;
            }
        }

        // While Loop For Username
        while (true) {
            if (choice == 1)
                System.out.println("\nEnter Your Username - ");
            else
                System.out.println("\nEnter Your Student Id - ");
            username = sc.nextLine();
            if (username.length() == 0) {
                System.out.println("Username Cannot Be An Empty Field.");
            } else {
                break;
            }
        }

        if (choice == 1) {
            System.out.println("\nEnter Course Id - ");
            courseId = sc.nextLine();

            // Validation Length & Only Char
            System.out.println("\nEnter Course Name - ");
            courseName = sc.nextLine();

            System.out.println("\nEnter Total Credits - ");
            credits = sc.nextInt();

            System.out.println("\nEnter Total Marks - ");
            totalMarks = sc.nextInt();

            // validation passing criteria must be btwn 1-100
            System.out.println("\nEnter Passing Criteria In Percentage - ");
            passingCriteria = sc.nextInt();

            course = new Course(courseId, courseName, credits, totalMarks, passingCriteria);
        }

        // While Loop For Password
        while (true) {
            System.out.print("\nEnter Your Password - ");
            password = new String(System.console().readPassword());
            for (int i = 0; i < password.length(); i++) {
                System.out.print("*");
            }
            System.out.println();

            if (Pattern.matches(passwordPattern, password)) {
                break;
            } else {
                System.out.println("\nPassword Must Contain At Least 8 Characters And At Most 20 Characters.");
                System.out.println("Password Must Contain At Least One Digit.");
                System.out.println("Password Must Contain At Least One Uppercase Alphabet.");
                System.out.println("Password Must Contain At Least One Lowercase Alphabet.");
                System.out.println("Password Must Contain At Least One Special Character.");
                System.out.println("Password Cannot Contain Space");
            }
        }

        System.out.print("\nConfirm Password - ");
        confirmPassword = new String(System.console().readPassword());
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }

        if (password.equals(confirmPassword)) {
            if (choice == 1) {
                Faculty faculty = new Faculty(fullName, username, password, course);
                facultiesList.add(faculty);
            } else {
                Student student = new Student(fullName, username, password);
                studentsList.add(student);
            }
            System.out.println("\n\nUser Registered Successfully...");
        } else {
            System.out.println("\n\nBoth Password Must Be Same\nTry Again...");
            RegisterUser();
        }
    }

    void SignIn() {
        System.out.println("\n=======");
        System.out.println("Sign In");
        System.out.println("=======");
        System.out.println("1. Faculty");
        System.out.println("2. Student");
        System.out.println("Enter Your Choice : ");
        choice = sc.nextInt();

        if (choice < 1 || choice > 2) {
            SignIn();
            return;
        }

        // While Loop For Username
        sc.nextLine();
        while (true) {
            if (choice == 1)
                System.out.println("\nEnter Your Username - ");
            else
                System.out.println("\nEnter Your Student Id - ");
            username = sc.nextLine();

            if (username.length() == 0) {
                System.out.println("Username Cannot Be An Empty Field...");
            } else {
                break;
            }
        }

        System.out.print("\nEnter Your Password - ");
        password = new String(System.console().readPassword());
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }

        System.out.println();
        if (choice == 1) {
            Faculty u = null;
            int index = -1;
            for (Faculty user : facultiesList) {
                index++;
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    u = user;
                    break;
                }
            }
            if (u != null) {
                System.out.println("\nWelcome " + u.getFullName());

                if (u.getStudents().size() == 0)
                    CourseRegistration(u);
                else
                    FacultyMenu(u);
            } else {
                System.out.println("\nIncorrect Password");
                while (true) {
                    System.out.println("\n1. Try Again");
                    System.out.println("2. Forgot Password");
                    System.out.println("0. Home Menu");
                    System.out.print("\nEnter Your Choice ( 0 - 2 ) : ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 1) {
                        SignIn();
                        break;
                    } else if (choice == 2) {
                        ForgetPassword(1);
                        break;
                    } else if (choice == 0) {
                        break;
                    } else {
                        System.out.println("\nEnter Valid Option...");
                    }
                }
            }
        } else {
            Student u = null;
            int index = -1;
            for (Student user : studentsList) {
                index++;
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    u = user;
                    break;
                }
            }
            if (u != null) {
                System.out.println("\nWelcome " + u.getFullName());
                ViewStudentDetails(u);
            } else {
                System.out.println("\nIncorrect Password");
                while (true) {
                    System.out.println("\n1. Try Again");
                    System.out.println("2. Forgot Password");
                    System.out.println("0. Home Menu");
                    System.out.print("\nEnter Your Choice ( 0 - 2 ) : ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 1) {
                        SignIn();
                        break;
                    } else if (choice == 2) {
                        ForgetPassword(2);
                        break;
                    } else if (choice == 0) {
                        break;
                    } else {
                        System.out.println("\nEnter Valid Option...");
                    }
                }
            }
        }
    }

    void ForgetPassword(int userType) {
        // If Condition For Faculty's Forget Password
        if (userType == 1) {
            Faculty u = null;
            while (true) {
                u = null;
                System.out.println("\nEnter Your Full Name - ");
                fullName = sc.nextLine();

                for (Faculty user : facultiesList) {
                    if (fullName.equals(user.getFullName())) {
                        u = user;
                        break;
                    }
                }

                if (u != null) {
                    while (true) {
                        System.out.print("\nEnter Your New Password - ");
                        password = new String(System.console().readPassword());
                        for (int i = 0; i < password.length(); i++) {
                            System.out.print("*");
                        }
                        System.out.println();

                        if (Pattern.matches(passwordPattern, password)) {
                            break;
                        } else {
                            System.out.println(
                                    "\nPassword Must Contain At Least 8 Characters And At Most 20 Characters.");
                            System.out.println("Password Must Contain At Least One Digit.");
                            System.out.println("Password Must Contain At Least One Uppercase Alphabet.");
                            System.out.println("Password Must Contain At Least One Lowercase Alphabet.");
                            System.out.println("Password Must Contain At Least One Special Character.");
                            System.out.println("Password Cannot Contain Space");
                        }
                    }

                    System.out.print("\nConfirm New Password - ");
                    confirmPassword = new String(System.console().readPassword());
                    for (int i = 0; i < password.length(); i++) {
                        System.out.print("*");
                    }

                    if (password.equals(confirmPassword)) {
                        u.setPassword(password);
                        System.out.println("\n\nPassword Changed Successfully...");
                        break;
                    } else {
                        System.out.println("\n\nBoth Password Must Be Same\nTry Again...");
                        sc.nextLine();
                    }
                } else {
                    System.out.println("\nUser Not Found...\nTry Again...");
                }
            }
        } else {
            // Else Condition For Student's Forget Password
            Student u = null;
            while (true) {
                u = null;
                System.out.println("\nEnter Your Full Name - ");
                fullName = sc.nextLine();

                for (Student user : studentsList) {
                    if (fullName.equals(user.getFullName())) {
                        u = user;
                        break;
                    }
                }

                if (u != null) {
                    while (true) {
                        System.out.print("\nEnter Your New Password - ");
                        password = new String(System.console().readPassword());
                        for (int i = 0; i < password.length(); i++) {
                            System.out.print("*");
                        }
                        System.out.println();

                        if (Pattern.matches(passwordPattern, password)) {
                            break;
                        } else {
                            System.out.println(
                                    "\nPassword Must Contain At Least 8 Characters And At Most 20 Characters.");
                            System.out.println("Password Must Contain At Least One Digit.");
                            System.out.println("Password Must Contain At Least One Uppercase Alphabet.");
                            System.out.println("Password Must Contain At Least One Lowercase Alphabet.");
                            System.out.println("Password Must Contain At Least One Special Character.");
                            System.out.println("Password Cannot Contain Space");
                        }
                    }

                    System.out.print("\nConfirm New Password - ");
                    confirmPassword = new String(System.console().readPassword());
                    for (int i = 0; i < password.length(); i++) {
                        System.out.print("*");
                    }

                    if (password.equals(confirmPassword)) {
                        u.setPassword(password);
                        System.out.println("\n\nPassword Changed Successfully...");
                        break;
                    } else {
                        System.out.println("\n\nBoth Password Must Be Same\nTry Again...");
                        sc.nextLine();
                    }
                } else {
                    System.out.println("\nUser Not Found...\nTry Again...");
                }
            }
        }
    }

    void CourseRegistration(Faculty fac) {
        System.out.println("\n=====================================");
        System.out.println("List Of Students Registered In System");
        System.out.println("=====================================");

        System.out.println("Student ID\t \tStudent Name\n");
        for (Student stud : studentsList) {
            System.out.println(stud.getUsername() + "\t-\t" + stud.getFullName());
        }

        System.out.println("\nEnter Student ID You Want To Register : ");
        System.out.println("Enter 0 To Stop...");
        long studentid;

        // While Loop For Adding Selected Student To StudentList of Faculty Object
        while (true) {
            System.out.println("Student ID : ");
            studentid = sc.nextLong();
            if (studentid == 0)
                break;

            for (Student stud : studentsList) {
                if (stud.getUsername().equals(Long.toString(studentid))) {
                    stud.addCourse(fac.getCourse());
                    fac.addStudent(stud);
                    break;
                }
            }
        }
    }

    void ViewStudentMarks(Faculty fac) {
        System.out.println("Student ID\tStudent Name\tObt. Marks\tTotal Marks");
        for (Student stud : fac.getStudents()) {
            for (CourseScore CS : stud.getScoreCard().getCourseScores()) {
                if (CS.getCourse().equals(fac.getCourse())) {
                    System.out.println(stud.getUsername() + "\t" + stud.getFullName());
                    System.out.print("\t" + CS.getObtainedMarks() + "\t" + CS.getCourse().getTotalMarks());
                }
            }
        }
    }

    void DisplayStudents(Faculty fac) {
        System.out.println("\n===============");
        System.out.println("Student Details");
        System.out.println("===============");
        System.out.println("\n---------------------------");
        System.out.println("Student Id\tStudent Name");
        System.out.println("---------------------------");
        for (Student stud : fac.getStudents()) {
            System.out.println(stud.getUsername() + "\t" + stud.getFullName());
            System.out.println("---------------------------");
        }
    }

    char CalculateGrade(float Percentage, Course course) {
        float passingCriteria = course.getPassingCriteria();
        float remainingCriteria = 100 - passingCriteria;
        float gradeA = 100 - (remainingCriteria / 3);
        float gradeB = 100 - (remainingCriteria / 3) * 2;
        float gradeC = 100 - remainingCriteria;

        if (Percentage <= 100 && Percentage > gradeA)
            return 'A';
        else if (Percentage <= gradeA && Percentage > gradeB)
            return 'B';
        else if (Percentage <= gradeB && Percentage > gradeC)
            return 'C';
        else
            return 'F';
    }

    int CalculateCredit(char grade, Course course) {
        if (grade == 'F')
            return 0;
        else
            return course.getCredits();
    }

    void AddStudentMarks(Faculty fac) {
        DisplayStudents(fac);

        String studid;
        int obtainedMarks;
        System.out.println("Enter Student Id - ");
        studid = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Obtained Marks : ");
        obtainedMarks = sc.nextInt();

        float Percentage = (obtainedMarks * 100) / (float) (fac.getCourse().getTotalMarks());

        char grade = CalculateGrade(Percentage, fac.getCourse());
        CourseScore CS = new CourseScore(fac.getCourse(), obtainedMarks, grade,
                CalculateCredit(grade, fac.getCourse()));

        for (Student stud : fac.getStudents()) {
            if (studid.equals(stud.getUsername())) {
                stud.getScoreCard().addCourseScore(CS);
                break;
            }
        }
    }

    void FacultyMenu(Faculty fac) {
        int choice;

        while (true) {
            System.out.println("\n====");
            System.out.println("Menu");
            System.out.println("====");

            System.out.println("\n1. Add Students Marks");
            System.out.println("2. View Students Marks");
            System.out.println("3. Update Students Marks");
            System.out.println("4. Add Students");
            System.out.println("5. Delete Students");
            System.out.println("6. Display Students");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AddStudentMarks(fac);
                    break;
                case 2:
                    ViewStudentMarks(fac);
                    break;
                case 3:
                    // ViewStudentMarks();
                    break;
                case 4:
                    // ViewStudentMarks();
                    break;
                case 5:
                    // ViewStudentMarks();
                    break;
                case 6:
                    DisplayStudents(fac);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Selection :");
                    break;
            }
        }

    }

    void ViewStudentDetails(Student stud) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n===============");
        System.out.println("Student Details");
        System.out.println("===============");

        System.out.println("\n------------------------");
        System.out.println("Student Id\tStudent Name");
        System.out.println(stud.getUsername() + "\t" + stud.getFullName());
        System.out.println("------------------------");

        System.out.println("\n=======");
        System.out.println("Courses");
        System.out.println("=======");

        if (stud.getCourses().size() > 0) {
            System.out.println("Course Id\tCourse Name");
            for (Course course : stud.getCourses()) {
                System.out.println(course.getCourseId() + "\t\t" + course.getCourseName());
            }
        } else {
            System.out.println("Student Is Not Registered In Any Courses...");
        }
    }
}