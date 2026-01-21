import java.util.Scanner;

public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distance(Point2D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Point2D[x=" + x + ", y=" + y + "]";
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter point1's x-, y-coordinates: ");
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            Point2D p1 = new Point2D(x1, y1);
            
            System.out.print("Enter point2's x-, y-coordinates: ");
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            Point2D p2 = new Point2D(x2, y2);
            
            System.out.println("p1 is " + p1);
            System.out.println("p2 is " + p2);
            
            double distance = p1.distance(p2);
            System.out.println("The distance between p1 and p2 is " + distance);
        }
    }
}
