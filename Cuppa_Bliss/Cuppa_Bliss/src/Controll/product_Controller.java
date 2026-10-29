
package Controll;

import Model.Product;
import Model.ProductDAO;
import java.util.List;

public class product_Controller {
    private final ProductDAO dao = new ProductDAO();

    public void addProduct(int id, String name, String category, double price, int qty) {
        Product p = new Product(id, name, category, price, qty);
        dao.addProduct(p);
    }

    public List<Product> getProducts() {
        return dao.getAllProducts();
    }

    public List<Product> searchProducts(String name) {
        return dao.searchProducts(name);
    }

    public List<Product> getLowStockProducts(int limit) {
        return dao.getLowStockProducts(limit);
    }
}
