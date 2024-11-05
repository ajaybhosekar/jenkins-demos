package demos.jdbc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import demos.jdbc.entity.Product;

public class ProductDAO {
    private Connection conn;

    public ProductDAO() {
        try {
            //when not dockerized
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_demos", "root", "123456");

            //when dockerized
            conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/jdbc_demos", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create a new product
    public void createProduct(Product product) {
        String query = "INSERT INTO product (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Update a product
    public void updateProduct(Product product) {
        String query = "UPDATE product SET name=?, price=?, quantity=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a product
    public void deleteProduct(int id) {
        String query = "DELETE FROM product WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
