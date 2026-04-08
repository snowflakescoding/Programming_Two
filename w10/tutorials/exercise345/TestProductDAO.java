package w10.tutorials.exercise345;

public class TestProductDAO {
    private static void expectInvalidProduct(int id, String name, double price) {
        try {
            Product rejected = new Product(id, name, price);
            System.out.println("  ERROR: Expected exception but got: " + rejected);
        } catch (IllegalArgumentException e) {
            System.out.println("  Caught expected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        System.out.println("========== Exercise 3: Product class ==========");
        Product p1 = new Product(1, "Laptop", 1200.00);
        Product p2 = new Product(2, "Mouse", 25.99);
        Product p3 = new Product(3, "Keyboard", 75.50);
        System.out.println("Created: " + p1);
        System.out.println("Created: " + p2);
        System.out.println("Created: " + p3);

        System.out.println("\n========== Exercise 4 & 5: DAO CRUD ==========");

        System.out.println("\n--- ADD ---");
        dao.add(p1);
        dao.add(p2);
        dao.add(p3);
        System.out.println("Added 3 products. List size: " + dao.getList().size());

        System.out.println("\n--- GET LIST ---");
        for (Product p : dao.getList()) {
            System.out.println("  " + p);
        }

        System.out.println("\n--- FIND ---");
        Product found = dao.find(2);
        System.out.println("Find ID=2:  " + found);
        Product notFound = dao.find(99);
        System.out.println("Find ID=99: " + notFound); // Expected: null

        System.out.println("\n--- UPDATE ---");
        Product updated = new Product(2, "Wireless Mouse", 45.00);
        dao.update(updated);
        System.out.println("After updating ID=2: " + dao.find(2));

        System.out.println("\n--- REMOVE ---");
        dao.remove(p3);
        System.out.println("Removed ID=3. List size: " + dao.getList().size());
        System.out.println("Find ID=3 after removal: " + dao.find(3));

        System.out.println("\n--- EXCEPTION HANDLING ---");

        try {
            Product duplicate = new Product(1, "Duplicate", 0);
            dao.add(duplicate);
        } catch (IllegalStateException e) {
            System.out.println("  Duplicate add caught: " + e.getMessage());
        }

        try {
            Product ghost = new Product(99, "Ghost", 0);
            dao.update(ghost);
        } catch (IllegalStateException e) {
            System.out.println("  Update non-existent caught: " + e.getMessage());
        }

        try {
            Product ghost = new Product(99, "Ghost", 0);
            dao.remove(ghost);
        } catch (IllegalStateException e) {
            System.out.println("  Remove non-existent caught: " + e.getMessage());
        }

        System.out.println("  Testing invalid constraints:");
        expectInvalidProduct(-1, "Bad ID", 10.0);
        expectInvalidProduct(10, "", 10.0);
        expectInvalidProduct(10, "Negative Price", -5.0);

        System.out.println("\n========== All tests completed ==========");
    }
}