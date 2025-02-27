package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product[] basket;

    public ProductBasket(int capacity) {
        this.basket = new Product[capacity];
    }

    public void addProduct(Product product) {
        boolean productAdded = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
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
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        boolean basketIsEmpty = true;
        int total = 0;
        int specialPositions = 0;
        for (Product product : basket) {
            if (product != null) {
                basketIsEmpty = false;
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialPositions++;
                }
                System.out.println(product);
            }
        }
        if (basketIsEmpty) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Итого: " + total);
            System.out.println("Специальных товаров: " + specialPositions);
        }
    }

    public boolean isProductInBasket(String name) {
        for (Product product : basket) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(basket, null);
    }
}
