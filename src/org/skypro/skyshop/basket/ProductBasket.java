package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] BASKET;

    public ProductBasket(int capacity) {
        this.BASKET = new Product[capacity];
    }

    public void addProduct(Product product) {
        boolean productAdded = false;
        for (int i = 0; i < BASKET.length; i++) {
            if (BASKET[i] == null) {
                BASKET[i] = product;
                productAdded = true;
                return;
            }
        }
        if (!productAdded) {
            System.out.println("Корзина переполнена. Невозможно добавить продукт " + product);
        }
    }

    public int totalPrice() {
        int total = 0;
        for (Product product : BASKET) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        boolean basketIsEmpty = true;
        int total = 0;
        for (Product product : BASKET) {
            if (product != null) {
                basketIsEmpty = false;
                total += product.getPrice();
                System.out.println(product.toString(true));
            }
        }
        if (basketIsEmpty) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Итого: " + total);
        }
    }

    public boolean isProductInBasket(String name) {
        for (Product product : BASKET) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(BASKET, null);
    }
}
