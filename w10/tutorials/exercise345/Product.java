package w10.tutorials.exercise345;

import java.io.Serializable;

public class Product implements Serializable, Identifiable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        if (id <= 0)
            throw new IllegalArgumentException("Product ID must be a positive integer.");
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Product name must not be null or empty.");
        if (name.length() > 100)
            throw new IllegalArgumentException("Product name must not exceed 100 characters.");
        if (price < 0)
            throw new IllegalArgumentException("Product price must be >= 0.");

        this.id = id;
        this.name = name.trim();
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive integer.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name must not be null or empty.");
        }
        if (name.length() > 100) {
            throw new IllegalArgumentException("Product name must not exceed 100 characters.");
        }
        this.name = name.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price must be >= 0.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f}", id, name, price);
    }
}
