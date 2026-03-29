import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final double gpa;
    private final String faculty;

    public Student(String name, double gpa, String faculty) {
        this.name    = name;
        this.gpa     = gpa;
        this.faculty = faculty;
    }

    public String getName()    { return name; }
    public double getGpa()     { return gpa; }
    public String getFaculty() { return faculty; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + ", faculty='" + faculty + "'}";
    }
}