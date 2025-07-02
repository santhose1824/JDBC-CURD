package com.examly.service;

import com.examly.entity.Product;
import com.examly.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public String addProduct(Product product) {
        String sql = "INSERT INTO products (name, category, quantity, price, inStock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setInt(3, product.getQuantity());
            stmt.setDouble(4, product.getPrice());
            stmt.setBoolean(5, product.isInStock());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0 ? "Product added successfully!" : "Failed to add product.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String updateProduct(Product product) {
        String sql = "UPDATE products SET name=?, category=?, quantity=?, price=?, inStock=? WHERE productid=?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory());
            stmt.setInt(3, product.getQuantity());
            stmt.setDouble(4, product.getPrice());
            stmt.setBoolean(5, product.isInStock());
            stmt.setInt(6, product.getProductId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0 ? "Product updated successfully!" : "Product not found.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE productid=?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0 ? "Product deleted successfully!" : "Product not found.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> searchByCategory(String category) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE category=?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> filterInStock() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE inStock=true";

        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        return new Product(
            rs.getInt("productid"),
            rs.getString("name"),
            rs.getString("category"),
            rs.getInt("quantity"),
            rs.getDouble("price"),
            rs.getBoolean("inStock")
        );
    }
}
