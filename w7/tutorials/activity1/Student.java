
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

    private final String name;
    private final LocalDate dateOfBirth;
    private final String studentId;
    private double gpa;
    private final Map<Course, Double> grades;

    public Student(String name, LocalDate dob, String sId) {
        this.name = name;
        this.dateOfBirth = dob;
        this.studentId = sId;
        this.gpa = 0.0;
        this.grades = new LinkedHashMap<>(); // preserve insertion order
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public Map<Course, Double> getGrades() {
        return Collections.unmodifiableMap(grades);
    }

    public void registerCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        grades.putIfAbsent(course, null);
        System.out.println("Registered: " + course.getName()
                + " (" + course.getCourseCode() + ") for " + name);
    }

    public void assignGrade(Course course, double grade) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        if (!grades.containsKey(course)) {
            throw new IllegalArgumentException(
                    "Course '" + course.getName() + "' is not registered for student " + name + ".");
        }
        if (grade < 0.0 || grade > 4.0) {
            throw new IllegalArgumentException("Grade must be between 0.0 and 4.0.");
        }
        grades.put(course, grade);
        calculateGPA();
        System.out.printf("Assigned grade %.2f for %s to %s%n",
                grade, course.getName(), name);
    }

    public void calculateGPA() {
        double totalWeightedGrade = 0.0;
        int totalCredits = 0;

        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            Double grade = entry.getValue();
            if (grade != null) {
                int credits = entry.getKey().getCredits();
                totalWeightedGrade += grade * credits;
                totalCredits += credits;
            }
        }

        this.gpa = (totalCredits > 0) ? totalWeightedGrade / totalCredits : 0.0;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("============================================\n");
        sb.append("           STUDENT RECORD                  \n");
        sb.append("============================================\n");
        sb.append(String.format("  Name        : %s%n", name));
        sb.append(String.format("  Student ID  : %s%n", studentId));
        sb.append(String.format("  Date of Birth: %s%n", dateOfBirth.format(formatter)));
        sb.append(String.format("  GPA         : %.2f%n", gpa));
        sb.append("--------------------------------------------\n");
        sb.append("  Enrolled Courses:\n");

        if (grades.isEmpty()) {
            sb.append("    (No courses registered)\n");
        } else {
            for (Map.Entry<Course, Double> entry : grades.entrySet()) {
                Course course = entry.getKey();
                Double grade = entry.getValue();
                String gradeStr = (grade != null) ? String.format("%.2f", grade) : "N/A";
                sb.append(String.format("    • %-35s | Credits: %d | Grade: %s%n",
                        course.getName() + " (" + course.getCourseCode() + ")",
                        course.getCredits(),
                        gradeStr));
            }
        }

        sb.append("============================================");
        return sb.toString();
    }
}
