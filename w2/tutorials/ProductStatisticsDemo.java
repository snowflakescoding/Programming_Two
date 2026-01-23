package w2.tutorials;

class Product {

    public String name;
    public double price;
    public double discount;
    public int quantity;

    private static int productCount = 0;
    private static int totalRevenue = 0;
    private static int totalDiscount = 0;

    public Product(String name, double price, double discount, int quantity) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;

        productCount++;
        updateStaticValues(0, quantity);
    }

    public Product(String name, double price, int quantity) {
        this(name, price, 0, quantity);
    }

    private void updateStaticValues(int oldQuantity, int newQuantity) {
        double oldDiscountedPrice = price * (1 - discount / 100);
        totalRevenue -= oldDiscountedPrice * oldQuantity;
        totalDiscount -= (price * discount / 100) * oldQuantity;

        double newDiscountedPrice = price * (1 - discount / 100);
        totalRevenue += newDiscountedPrice * newQuantity;
        totalDiscount += (price * discount / 100) * newQuantity;
    }

    private double getImportTax() {
        return price * 0.10;
    }

    public void displayInfo() {
        System.out.println("Product: " + name
                + " Price: $" + String.format("%.2f", price)
                + " Discount: " + (int) discount + "%"
                + " Quantity: " + quantity
                + " Import Tax: $" + String.format("%.2f", getImportTax()));
    }

    public void updateQuantity(int newQuantity) {
        updateStaticValues(this.quantity, newQuantity);
        this.quantity = newQuantity;
    }

    public static int getProductCount() {
        return productCount;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageDiscount() {
        if (totalRevenue + totalDiscount == 0) {
            return 0;
        }
        return (totalDiscount / (totalRevenue + totalDiscount)) * 100;
    }

    public static void displayStatistics() {
        System.out.println("\n=== Product Statistics ===");
        System.out.println("Total Products Created: " + getProductCount());
        System.out.println("Total Potential Revenue: $" + String.format("%.2f", getTotalRevenue()));
        System.out.println("Average Discount: " + String.format("%.2f", getAverageDiscount()) + "%");
    }
}

public class ProductStatisticsDemo {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 1000.00, 10, 50);
        Product mouse = new Product("Mouse", 25.00, 5, 200);
        Product keyboard = new Product("Keyboard", 75.00, 0, 100);
        
        laptop.displayInfo();
        mouse.displayInfo();
        keyboard.displayInfo();
        
        Product.displayStatistics();
        
        System.out.println("\n--- Updating Laptop quantity to 75 ---");
        laptop.updateQuantity(75);
        
        Product.displayStatistics();
    }
}
