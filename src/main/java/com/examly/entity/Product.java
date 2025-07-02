package com.examly.entity;

public class Product
{
    private int productId;
    private String name;
    private String category;
    private int quantity;
    private double  price;
    private boolean inStock;


    public Product(){}

    public Product(int productId, String name, String category, int quantity, double price, boolean inStock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.inStock = inStock;
    }


    public int getProductId() {
        return productId;
    }

    public void  setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return  price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public boolean isInStock()
    {
        return inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }

    @Override
    public String toString()
    {
        return "Product ID: " + productId + ", Name: " + name + ", Category: " + category + ", Quantity: " + quantity + ", Price: " + price + ", In Stock: " + inStock;
    }
}
