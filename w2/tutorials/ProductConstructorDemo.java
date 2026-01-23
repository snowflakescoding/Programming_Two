package w2.tutorials;

import java.util.Scanner;

class Product {
    public String name;
    public double price;
    public double discount;
    
    public Product(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.discount = 0; 
    }
    
    private double getImportTax() {
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

public class ProductConstructorDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0, 10.0);
        Product product2 = new Product("Mouse", 25.0);
        
        System.out.println("=== Product with Discount ===");
        product1.displayInfo();
        
        System.out.println("=== Product without Discount ===");
        product2.displayInfo();
    }
}