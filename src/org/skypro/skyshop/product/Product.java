package org.skypro.skyshop.product;

import org.skypro.skyshop.services.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getContentType() {
        return "Product";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

}