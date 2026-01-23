package tutorials;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    private static final HashMap<String, Integer> students = new HashMap<>();

    public static void addStudent(String name, int grade) {
        students.put(name, grade);
    }

    public static double getAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : students.values()) {
            sum += grade;
        }

        return (double) sum / students.size();
    }

    public static String getTopStudent() {
        if (students.isEmpty()) {
            return null;
        }

        String topStudent = null;
        int highestGrade = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() > highestGrade) {
                highestGrade = entry.getValue();
                topStudent = entry.getKey();
            }
        }

        return topStudent;
    }

    public static void main(String[] args) {
        addStudent("Alice", 85);
        addStudent("Bob", 92);
        addStudent("Charlie", 78);

        System.out.println("Average grade: " + getAverage());
        System.out.println("Top student: " + getTopStudent());

        System.out.println("\nEmpty collection test:");
        students.clear();
        System.out.println("Average (empty): " + getAverage());

        String topStudent = getTopStudent();
        if (topStudent != null) {
            System.out.println("Top student: " + topStudent);
        } else {
            System.out.println("No students found");
        }
    }
}
