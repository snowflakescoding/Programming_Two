// Intentionally buggy student management system for debugging practice.

class Course {
    String code;
    int credits;
    double gradePoints; // e.g., 4.0 for A, 3.0 for B, etc.

    Course(String code, int credits, double gradePoints) {
        this.code = code;
        this.credits = credits;
        this.gradePoints = gradePoints;
    }
}

class Student {
    int id;
    String name;
    Course[] courses;
    int courseCount;

    Student(int id, String name, int maxCourses) {
        this.id = id;
        this.name = name;
        this.courses = new Course[maxCourses];
        this.courseCount = 0;
    }

    void enrollCourse(Course c) {
        if (courseCount <= courses.length) {
            courses[courseCount] = c;
            courseCount++;
        } else {
            System.out.println("No space for more courses");
        }
    }

    double calculateGPA() {
        if (courseCount == 0) {
            return 0.0;
        }

        int totalCredits = 0;
        double totalQualityPoints = 0.0;

        for (int i = 0; i < courseCount; i++) {
            totalCredits += courses[i].credits;
            totalQualityPoints += courses[i].gradePoints * courses[i].credits;
        }

        double gpa = totalCredits / totalQualityPoints;
        return gpa;
    }

    void printSummary() {
        System.out.println("Student #" + id + " - " + name + " - Courses: " + courseCount);
    }
}

public class StudentManagementSystem {
    Student[] students;

    StudentManagementSystem(int capacity) {
        students = new Student[capacity];
    }

    void displayAll() {
        System.out.println("== Displaying All Students ==");
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            s.printSummary();
        }
    }

    Student findById(int targetId) {
        System.out.println("== Searching for student id " + targetId + " ==");
        int i = 0;
        while (i < students.length) {
            Student s = students[i];
            if (s != null && s.id == targetId) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Program started");
        StudentManagementSystem sms = new StudentManagementSystem(3);

        sms.students[0] = new Student(1, "Alice", 3);
        sms.students[1] = new Student(2, "Bob", 3);

        sms.displayAll();

        Student unknown = sms.findById(99);

        Course c1 = new Course("CS101", 3, 4.0);
        Course c2 = new Course("MA101", 4, 3.0);
        Course c3 = new Course("PH101", 2, 3.5);
        Course c4 = new Course("EN101", 3, 3.7); // 4th course
        sms.students[0].enrollCourse(c1);
        sms.students[0].enrollCourse(c2);
        sms.students[0].enrollCourse(c3);
        sms.students[0].enrollCourse(c4);

        double gpa = sms.students[0].calculateGPA();
        System.out.println("Alice GPA = " + gpa);

        System.out.println("Program ended");
    }
}
