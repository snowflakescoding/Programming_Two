import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Student alice = new Student("Alice Johnson",
                LocalDate.of(2002, 5, 14), "S1001");

        Student bob = new Student("Bob Smith",
                LocalDate.of(2001, 11, 30), "S1002");

        System.out.println("\n=== Student Management System Demo ===\n");

        JavaCourse javaProgramming = new JavaCourse(
                "Java Programming", "CS101", 4);

        JavaCourse dataStructures = new JavaCourse(
                "Data Structures & Algorithms", "CS201", 3);

        JavaCourse databases = new JavaCourse(
                "Database Systems", "CS301", 3);

        System.out.println("--- Registering courses for Alice ---");
        alice.registerCourse(javaProgramming);
        alice.registerCourse(dataStructures);
        alice.registerCourse(databases);

        Course specialSubject = new Course() {
            @Override
            public String getName() {
                return "Special Subject: AI Ethics";
            }

            @Override
            public String getCourseCode() {
                return "SS999";
            }

            @Override
            public int getCredits() {
                return 2;
            }

            @Override
            public String toString() {
                return getName() + " (" + getCourseCode() + ") - " + getCredits() + " credits";
            }
        };

        System.out.println("\n--- Enrolling Alice in Special Subject (anonymous class) ---");
        alice.registerCourse(specialSubject);

        System.out.println("\n--- Assigning grades for Alice ---");
        alice.assignGrade(javaProgramming, 3.7);
        alice.assignGrade(dataStructures, 3.3);
        alice.assignGrade(databases, 4.0);
        alice.assignGrade(specialSubject, 3.5);

        System.out.println("\n--- Registering and grading courses for Bob ---");
        bob.registerCourse(javaProgramming);
        bob.registerCourse(dataStructures);
        bob.assignGrade(javaProgramming, 2.7);

        System.out.println("\n\n=== Final Student Records ===\n");
        System.out.println(alice);
        System.out.println();
        System.out.println(bob);

        System.out.println("\n\n=== Error Handling Demo ===\n");

        JavaCourse unregistered = new JavaCourse("Operating Systems", "CS401", 3);
        try {
            alice.assignGrade(unregistered, 3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        try {
            alice.assignGrade(javaProgramming, 5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
