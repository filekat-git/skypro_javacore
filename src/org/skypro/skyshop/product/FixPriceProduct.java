package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;

    private int price;

    public FixPriceProduct(String name) {
        super(name);
        this.price = FIX_PRICE;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт с фиксированной ценой: " + getName() + ", стоимость: " + getPrice();
    }
}
