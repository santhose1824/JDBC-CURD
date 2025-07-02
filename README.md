# Inventory Management System (Java + JDBC + MySQL)

A console-based Inventory Management System built using Core Java and JDBC. This application connects to a MySQL database to perform CRUD operations on products. It allows users to add, update, delete, view, and search for products based on category and stock status.

---

## 📁 Project Structure

inventoryManagment/
├── lib/
│ └── mysql-connector-j-9.3.0.jar
├── bin/
├── src/
│ └── main/java/com/examly/
│ ├── entity/
│ │ └── Product.java
│ ├── service/
│ │ ├── ProductService.java
│ │ └── ProductServiceImpl.java
│ ├── util/
│ │ └── DBConnectionUtil.java
│ └── MainModule.java

## 🧰 Technologies Used

- Java 17+
- JDBC
- MySQL 8+
- MySQL Connector/J (v9.3.0)
- VS Code or any Java IDE

---

## Open Command Prompt/ Terminal
## Now follow the below steps

1)mysqlsh
2)\sql
3)\connect --user "user_name" --password "Password"
4)CREATE DATABASE appdb;
5)USE appdb;
6)CREATE TABLE products (
    productid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    inStock BOOLEAN NOT NULL
);


## To compile the project in VSCode use the belwo command
javac -cp "lib/mysql-connector-j-9.3.0.jar" -d bin src\main\java\com\examly\*.java src\main\java\com\examly\entity\*.java src\main\java\com\examly\service\*.java src\main\java\com\examly\util\*.java
## TO run the project use the below command 
java -cp "bin;lib/mysql-connector-j-9.3.0.jar" com.examly.MainModule


## Output looks like below 
--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 1
Enter product name: Shirts
Enter category: Casuals 
Enter quantity: 10
Enter price: 28999.34
Is it in stock? (true/false): false
Product added successfully!

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 4
Product ID: 1, Name: Laptop, Category: Gadgets, Quantity: 20, Price: 5000.34, In Stock: true
Product ID: 2, Name: Ben10Watch, Category: Toys, Quantity: 30, Price: 100.45, In Stock: true
Product ID: 3, Name: Shirts, Category: Casuals, Quantity: 10, Price: 28999.34, In Stock: false

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 6
Product ID: 1, Name: Laptop, Category: Gadgets, Quantity: 20, Price: 5000.34, In Stock: true
Product ID: 2, Name: Ben10Watch, Category: Toys, Quantity: 30, Price: 100.45, In Stock: true

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 5
Enter category: Toys
Product ID: 2, Name: Ben10Watch, Category: Toys, Quantity: 30, Price: 100.45, In Stock: true

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 2
Enter product ID to update: 2
Enter new name: Ben10
Enter new category: Toys
Enter new quantity: 10
Enter new price: 283.45
Is it in stock? (true/false): false
Product updated successfully!

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 3
Enter product ID to delete: 3
Product deleted successfully!

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice: 4
Product ID: 1, Name: Laptop, Category: Gadgets, Quantity: 20, Price: 5000.34, In Stock: true
Product ID: 2, Name: Ben10, Category: Toys, Quantity: 10, Price: 283.45, In Stock: false

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. View All Products
5. Search by Category
6. Filter In-Stock Products
0. Exit
Enter your choice:
