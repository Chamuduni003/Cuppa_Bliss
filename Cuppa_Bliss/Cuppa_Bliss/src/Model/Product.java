package Model;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;

    public Product(int productId, String productName, String category, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
   
    @Override      // polymorphism
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + 
               ", Category=" + category + ", Price=" + price + 
               ", Quantity=" + quantity + "]";
    }
}



















