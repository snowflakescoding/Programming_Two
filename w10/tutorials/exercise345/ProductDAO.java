package w10.tutorials.exercise345;

public class ProductDAO extends DAO<Product> {
    @Override
    public void update(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot update with a null product.");
        }

        for (Product p : getList()) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return;
            }
        }

        throw new IllegalStateException(
                "No product with ID " + product.getId() + " found for update.");
    }

    @Override
    public Product find(int id) {
        for (Product p : getList()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
