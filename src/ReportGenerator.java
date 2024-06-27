import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Comparator;

public class ReportGenerator {
    private List<StudentGrade> studentGrades;

    public ReportGenerator(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public void generateReport(String outputFilePath) {
        if (studentGrades == null || studentGrades.isEmpty()) {
            System.out.println("No student grades available to generate report.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            Classroom classroom = new Classroom(studentGrades);

            // Find student with the highest grade
            StudentGrade maxGradeStudent = classroom.getMaxGrade();
            if (maxGradeStudent == null) {
                System.out.println("No maximum grade found.");
                return;
            }

            // Calculate average grade
            double averageGrade = studentGrades.stream()
                    .mapToInt(StudentGrade::getGrade)
                    .average()
                    .orElse(0);

            // Find student with the closest grade to the average
            StudentGrade closestToAverageStudent = studentGrades.stream()
                    .min(Comparator.comparingDouble(sg -> Math.abs(sg.getGrade() - averageGrade)))
                    .orElse(null);
            if (closestToAverageStudent == null) {
                System.out.println("No average grade found.");
                return;
            }

            // Find student with the lowest grade
            StudentGrade minGradeStudent = classroom.getWorstGrade();
            if (minGradeStudent == null) {
                System.out.println("No minimum grade found.");
                return;
            }

            // Write the results to the output file
            writer.write("Highest grade: " + maxGradeStudent.getName() + " " + maxGradeStudent.getGrade() + "\n");
            writer.write("Average grade: " + closestToAverageStudent.getName() + " " + closestToAverageStudent.getGrade() + "\n");
            writer.write("Lowest grade: " + minGradeStudent.getName() + " " + minGradeStudent.getGrade() + "\n");

            System.out.println("Report generated successfully: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
