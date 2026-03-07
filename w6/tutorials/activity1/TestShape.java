public class TestShape {

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle("Red", 10, 5);
        Triangle  tri1  = new Triangle("Blue", 8, 6);

        System.out.println("=== Direct Instantiation ===");
        System.out.println(rect1);
        System.out.println(tri1);
        System.out.printf("rect1 area : %.2f%n", rect1.getArea());
        System.out.printf("tri1  area : %.2f%n", tri1.getArea());

        System.out.println("\n=== Upcasting ===");
        Shape shape1 = new Rectangle("Green", 7, 3);
        Shape shape2 = new Triangle("Yellow", 5, 4);

        System.out.printf("shape1 area: %.2f%n", shape1.getArea());
        System.out.printf("shape2 area: %.2f%n", shape2.getArea());

        System.out.println("\n=== Polymorphism via Shape Array ===");
        Shape[] shapes = {
            new Rectangle("Purple", 12, 4),
            new Triangle("Orange", 9, 6),
            new Rectangle("Black", 3, 3),
            new Triangle("Pink", 7, 10)
        };

        double totalArea = 0;
        for (Shape s : shapes) {
            System.out.println(s);
            System.out.printf("  -> Area: %.2f%n", s.getArea()); 
            totalArea += s.getArea();
        }

        System.out.printf("%nTotal area of all shapes: %.2f%n", totalArea);

        System.out.println("\n=== Downcasting ===");
        Shape genericShape = new Rectangle("Teal", 6, 2);

        if (genericShape instanceof Rectangle r) {
            System.out.println("Downcast successful!");
            System.out.println("Length: " + r.getLength() + ", Width: " + r.getWidth());
        }
    }
}