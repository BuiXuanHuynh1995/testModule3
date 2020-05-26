package model;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private int quantity;
    private String color;
    private String description;
    private int categoryId;

    public Product() {
    }

    public Product(String productName, float price, int quantity, String color, String description, int categoryId) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product(int productId, String productName, float price, int quantity, String color, String description, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
