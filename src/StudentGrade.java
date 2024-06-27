public class StudentGrade {
    private String name;
    private String discipline;
    private int grade;

    public StudentGrade(String name, String discipline, int grade) {
        this.name = name;
        this.discipline = discipline;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + "|" + discipline + "|" + grade;
    }
}

