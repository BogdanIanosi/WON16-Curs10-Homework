import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Files/grades.txt";
        String reportFilePath = "grade-reports.out";

        try {
            GradeFileReader gradeFileReader = new GradeFileReader(filePath);
            List<StudentGrade> studentGrades = gradeFileReader.readGrades();

            Classroom classroom = new Classroom(studentGrades);
            System.out.println("Grades for Mathematics: " + classroom.getGradesForDiscipline("Mathematics"));
            System.out.println("Grades for Amilia Hilaria: " + classroom.getGradesForStudent("Amilia Hilaria"));
            System.out.println("Max grade in Mathematics: " + classroom.getMaxGrade("Mathematics"));
            System.out.println("Max grade overall: " + classroom.getMaxGrade());
            System.out.println("Average grade in Mathematics: " + classroom.getAverageGrade("Mathematics"));
            System.out.println("Worst grade in Mathematics: " + classroom.getWorstGrade("Mathematics"));

            ReportGenerator reportGenerator = new ReportGenerator(studentGrades);
            reportGenerator.generateReport(reportFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
