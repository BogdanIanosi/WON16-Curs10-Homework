import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GradeFileReader {
    private String filePath;

    public GradeFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<StudentGrade> readGrades() throws IOException {
        List<StudentGrade> studentGrades = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String name = parts[0];
            String discipline = parts[1];
            int grade = Integer.parseInt(parts[2]);
            studentGrades.add(new StudentGrade(name, discipline, grade));
        }
        reader.close();
        return studentGrades;
    }
}

