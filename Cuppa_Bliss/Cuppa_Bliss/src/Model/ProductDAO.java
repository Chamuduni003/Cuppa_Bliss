
package Model;

import DataBasePackage.DBconnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void addProduct(Product p) {
        try (Connection con = DBconnect.connect()) {
            String sql = "INSERT INTO product (product_id, name, category, price, quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, p.getProductId());
            pst.setString(2, p.getProductName());
            pst.setString(3, p.getCategory());
            pst.setDouble(4, p.getPrice());
            pst.setInt(5, p.getQuantity());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBconnect.connect()) {
            String sql = "SELECT product_id, name, category, price, quantity FROM product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchProducts(String name) {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBconnect.connect()) {
            String sql = "SELECT product_id, name, category, price, quantity FROM product WHERE name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getLowStockProducts(int limit) {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBconnect.connect()) {
            String sql = "SELECT product_id, name, category, price, quantity FROM product WHERE quantity < ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, limit);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
