public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
        // default
    }

    public Circle (double r) {
        this.radius = r;
    }

    public Circle (double r, String c) {
        this.radius = r;
        this.color = c;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2.0, "blue");
        Circle c2 = new Circle(2.0);
        Circle c3 = new Circle();

        System.out.println("Circle c1:");
        System.out.println("  Radius: " + c1.getRadius());
        System.out.println("  Color: " + c1.getColor());
        System.out.println("  Area: " + c1.getArea());
        System.out.println();
        
        System.out.println("Circle c2:");
        System.out.println("  Radius: " + c2.getRadius());
        System.out.println("  Color: " + c2.getColor());
        System.out.println("  Area: " + c2.getArea());
        System.out.println();
        
        System.out.println("Circle c3:");
        System.out.println("  Radius: " + c3.getRadius());
        System.out.println("  Color: " + c3.getColor());
        System.out.println("  Area: " + c3.getArea());
    }
}




