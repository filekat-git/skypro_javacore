package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            return basePrice - (basePrice * discountPercentage / 100);
        }
        return basePrice;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт со скидкой: " + getName() + ", стоимость: " + getPrice() + ", скидка: " + getDiscountPercentage() + "%";
    }
}
