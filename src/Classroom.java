import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Classroom {
    private List<StudentGrade> studentGrades;

    public Classroom(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public List<Integer> getGradesForDiscipline(String discipline) {
        return studentGrades.stream()
                .filter(sg -> sg.getDiscipline().equals(discipline))
                .map(StudentGrade::getGrade)
                .collect(Collectors.toList());
    }

    public List<Integer> getGradesForStudent(String student) {
        return studentGrades.stream()
                .filter(sg -> sg.getName().equals(student))
                .map(StudentGrade::getGrade)
                .collect(Collectors.toList());
    }

    public StudentGrade getMaxGrade(String discipline) {
        return studentGrades.stream()
                .filter(sg -> sg.getDiscipline().equals(discipline))
                .max(Comparator.comparingInt(StudentGrade::getGrade))
                .orElse(null);
    }

    public StudentGrade getMaxGrade() {
        return studentGrades.stream()
                .max(Comparator.comparingInt(StudentGrade::getGrade))
                .orElse(null);
    }

    public int getAverageGrade(String discipline) {
        return (int) studentGrades.stream()
                .filter(sg -> sg.getDiscipline().equals(discipline))
                .mapToInt(StudentGrade::getGrade)
                .average()
                .orElse(0);
    }

    public StudentGrade getWorstGrade(String discipline) {
        return studentGrades.stream()
                .filter(sg -> sg.getDiscipline().equals(discipline))
                .min(Comparator.comparingInt(StudentGrade::getGrade))
                .orElse(null);
    }

    public StudentGrade getWorstGrade() {
        return studentGrades.stream()
                .min(Comparator.comparingInt(StudentGrade::getGrade))
                .orElse(null);
    }
}
