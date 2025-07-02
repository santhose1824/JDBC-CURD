package com.examly.service;

import com.examly.entity.Product;
import java.util.List;

public interface ProductService
{
    String addProduct(Product product);
    String updateProduct(Product product);
    String deleteProduct(int productId);
    List<Product> getAllProducts();
    List<Product>searchByCategory(String category);
    List<Product>filterInStock();
}