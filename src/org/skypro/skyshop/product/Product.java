package org.skypro.skyshop.product;

public abstract class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

}