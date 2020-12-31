package xyz.demo.thymeleaf.entity;

public final class Product {

    private String name;
    private double price;
    private boolean inStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean inStock() {
        return inStock;
    }

    public void setStock(boolean stock) {
        inStock = stock;
    }
}
