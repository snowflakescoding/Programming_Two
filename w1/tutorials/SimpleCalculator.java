package tutorials;

public class SimpleCalculator {

    private double result;

    public SimpleCalculator() {
        this.result = 0.0;
    }

    public double add(double a, double b) {
        this.result = a + b;
        return result;
    }

    public double subtract(double a, double b) {
        this.result = a - b;
        return result;
    }

    public double multiply(double a, double b) {
        this.result = a * b;
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        this.result = a / b;
        return result;
    }

    public double getResult() {
        return this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("4 * 2 = " + calc.multiply(4, 2));
        System.out.println("10 - 6 = " + calc.subtract(10, 6));
        try {
            System.out.println("8 / 2 = " + calc.divide(8, 2));
            System.out.println("5 / 0 = " + calc.divide(5, 0));

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Final result: " + calc.getResult());
    }
}
