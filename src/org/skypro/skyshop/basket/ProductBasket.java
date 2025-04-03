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
        int total = 0;
        for (Map.Entry<Product, List<Product>> entry: basket.entrySet()) {
            Product key = entry.getKey();
            if (key != null) {
                int quantity = entry.getValue() == null ? 0: entry.getValue().size();
                total += key.getPrice() * quantity;
            }
        }
        return total;
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            int total = 0;
            int specialPositions = 0;
            for (Map.Entry<Product, List<Product>> entry : basket.entrySet()) {
                Product key = entry.getKey();
                if (key!=null) {
                    int quantity = entry.getValue() == null ? 0: entry.getValue().size();
                    total += key.getPrice() * quantity;
                    if (key.isSpecial()) {
                        specialPositions++;
                    }
                    System.out.println(key + ", шт: " + quantity);
                }
            }
            System.out.println("Итого: " + total);
            System.out.println("Специальных товаров: " + specialPositions);
        }
    }

    public boolean isProductInBasket(String name) {
        for (Map.Entry<Product, List<Product>> entry: basket.entrySet()) {
            Product key = entry.getKey();
            if (key != null && key.getName().equals(name)) {
                return true;
            }
        }
        return false;
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
