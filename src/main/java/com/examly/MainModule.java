package com.examly;

import com.examly.entity.Product;
import com.examly.service.ProductService;
import com.examly.service.ProductServiceImpl;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductServiceImpl();
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Search by Category");
            System.out.println("6. Filter In-Stock Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addProduct(sc, productService);
                case 2 -> updateProduct(sc, productService);
                case 3 -> deleteProduct(sc, productService);
                case 4 -> viewAllProducts(productService);
                case 5 -> searchByCategory(sc, productService);
                case 6 -> filterInStock(productService);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void addProduct(Scanner sc, ProductService service) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Is it in stock? (true/false): ");
        boolean inStock = Boolean.parseBoolean(sc.nextLine());

        Product p = new Product(0, name, category, quantity, price, inStock);
        System.out.println(service.addProduct(p));
    }

    private static void updateProduct(Scanner sc, ProductService service) {
        System.out.print("Enter product ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new category: ");
        String category = sc.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Is it in stock? (true/false): ");
        boolean inStock = Boolean.parseBoolean(sc.nextLine());

        Product p = new Product(id, name, category, quantity, price, inStock);
        System.out.println(service.updateProduct(p));
    }

    private static void deleteProduct(Scanner sc, ProductService service) {
        System.out.print("Enter product ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println(service.deleteProduct(id));
    }

    private static void viewAllProducts(ProductService service) {
        List<Product> products = service.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void searchByCategory(Scanner sc, ProductService service) {
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        List<Product> products = service.searchByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found in this category.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void filterInStock(ProductService service) {
        List<Product> products = service.filterInStock();
        if (products.isEmpty()) {
            System.out.println("No in-stock products available.");
        } else {
            products.forEach(System.out::println);
        }
    }
}