package tutorials;

public class Employee {

    private final int id;
    private final String firstName;
    private final String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        return salary + (salary * (percent / 100));
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ",name=" + firstName + " " + lastName + ",salary=" + salary + "]";
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "John", "Doe", 5000);
        System.out.println(e1); // test toString()

        // Test getters
        System.out.println("ID: " + e1.getId());
        System.out.println("First Name: " + e1.getFirstName());
        System.out.println("Last Name: " + e1.getLastName());
        System.out.println("Full Name: " + e1.getName());
        System.out.println("Salary: " + e1.getSalary());
        System.out.println("Annual Salary: " + e1.getAnnualSalary());
        System.out.println();

        // Test setter
        e1.setSalary(6000);
        System.out.println("After setting salary to 6000:");
        System.out.println(e1);
        System.out.println();

        // Test raiseSalary method
        System.out.println("Raising salary by 10%:");
        int newSalary = e1.raiseSalary(10);
        System.out.println("New salary returned: " + newSalary);
        System.out.println(e1);
        System.out.println();

        // Create another employee to test
        Employee e2 = new Employee(102, "Jane", "Smith", 8000);
        System.out.println(e2);
        System.out.println("Annual Salary: " + e2.getAnnualSalary());

        // Raise salary by 15%
        System.out.println("Raising salary by 15%:");
        e2.raiseSalary(15);
        System.out.println(e2);
        System.out.println("New Annual Salary: " + e2.getAnnualSalary());
    }
}
