import java.util.Random;

class Student {
    private int quizzes;
    private int midterms;
    private int finals;

    public Student(int quizzes, int midterms, int finals) {
        this.quizzes = quizzes;
        this.midterms = midterms;
        this.finals = finals;
    }

    public int getOverallGrade() {
        return (int) (quizzes * 0.2 + midterms * 0.3 + finals * 0.5);
    }

    public String getLetterGrade() {
        int overallGrade = getOverallGrade();
        if (overallGrade >= 85) {
            return "A";
        } else if (overallGrade >= 65) {
            return "B";
        } else if (overallGrade >= 50) {
            return "C";
        } else {
            return "F";
        }
    }
}

public class Main {

    private static final int STUDENT_COUNT = 20;
    private static final int QUIZZES_INDEX = 0;
    private static final int MIDTERMS_INDEX = 1;
    private static final int FINALS_INDEX = 2;

    public static void main(String[] args) {
        Student[] students = new Student[STUDENT_COUNT];
        initiateStudents(students);
        printScores(students);
        printAverages(students);
        printOverallGrades(students);
        printLetterGrades(students);
    }

    private static void initiateStudents(Student[] students) {
        Random random = new Random();
        for (int i = 0; i < STUDENT_COUNT; i++) {
            int quizzes = random.nextInt(101);
            int midterms = random.nextInt(101);
            int finals = random.nextInt(101);
            students[i] = new Student(quizzes, midterms, finals);
        }
    }

    private static void printScores(Student[] students) {
        for (Student student : students) {
            System.out.println("Quiz: " + student.getOverallGrade() + " Midterm: " + student.getOverallGrade() + " Final: " + student.getOverallGrade());
        }
    }

    private static void printAverages(Student[] students) {
        int totalQuizzes = 0, totalMidterms = 0, totalFinals = 0;
        for (Student student : students) {
            totalQuizzes += student.getOverallGrade();
            totalMidterms += student.getOverallGrade();
            totalFinals += student.getOverallGrade();
        }
        System.out.println("Average quiz grade: " + totalQuizzes / STUDENT_COUNT);
        System.out.println("Average midterm grade: " + totalMidterms / STUDENT_COUNT);
        System.out.println("Average final grade: " + totalFinals / STUDENT_COUNT);
    }

    private static void printOverallGrades(Student[] students) {
        System.out.println("\nSTUDENTS' OVERALL GRADES:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Overall grade of student " + (i + 1) + " is " + students[i].getOverallGrade());
        }
    }

    private static void printLetterGrades(Student[] students) {
        System.out.println("\nSTUDENTS' LETTER GRADES:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Letter grade of student " + (i + 1) + " is " + students[i].getLetterGrade());
        }
    }
}
