package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductBasket {

    private final Map<Product, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void add(Product product) {
        basket.computeIfAbsent(product, k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        return basket.values().stream()
                .flatMap(product -> product.stream())
                .mapToInt(product -> product.getPrice())
                .sum();
    }

    private long getSpecialCount() {
        return basket.values().stream()
                .flatMap(product -> product.stream())
                .filter(product -> product.isSpecial())
                .count();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            basket.values().stream()
                    .flatMap(product -> product.stream())
                    .forEach(System.out::println);
            System.out.println("Итого: " + totalPrice());
            System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    public boolean isProductInBasket(String name) {
        return basket.values().stream()
                .flatMap(products -> products.stream())
                .anyMatch(product -> product.getName().equals(name));
    }

    public List<Product> remove(String name) {
        List<Product> removedElements = new ArrayList<>();
        Iterator<Map.Entry<Product, List<Product>>> iterator = basket.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Product, List<Product>> entry = iterator.next();
            Product key = entry.getKey();
            if (key != null && key.getName().toLowerCase().contains(name.toLowerCase())) {
                removedElements.add(key);
                iterator.remove();
            }
        }
        return removedElements;
    }

}
