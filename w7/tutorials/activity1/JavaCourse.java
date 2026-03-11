
public class JavaCourse implements Course {

    private final String name;
    private final String courseCode;
    private final int credits;

    public JavaCourse(String name, String courseCode, int credits) {
        this.name = name;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d credits", name, courseCode, credits);
    }

}
