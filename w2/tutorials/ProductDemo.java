package w2.tutorials;

import java.util.Scanner;

// Exercise 1
class Product {
    public String name;
    public double price;
    public double discount;
    
    public double getImportTax() {
        return price * 0.10;
    }
    
    public void displayInfo() {
        System.out.println("Product name: " + name);
        System.out.println("Unit price: $" + String.format("%.2f", price));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Import tax: $" + String.format("%.2f", getImportTax()));
        System.out.println("------------------------");
    }
    
    public void input(Scanner scanner) {
        System.out.print("Enter product name: ");
        name = scanner.nextLine();
        System.out.print("Enter price: ");
        price = scanner.nextDouble();
        System.out.print("Enter discount (%): ");
        discount = scanner.nextDouble();
        scanner.nextLine(); 
    }
}

// Exercise 2
public class ProductDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Product product1 = new Product();
            Product product2 = new Product();

            System.out.println("Enter information for Product 1:");
            product1.input(scanner);

            System.out.println("\nEnter information for Product 2:");
            product2.input(scanner);

            System.out.println("\n=== Product 1 Information ===");
            product1.displayInfo();

            System.out.println("=== Product 2 Information ===");
            product2.displayInfo();
        }
    }
}