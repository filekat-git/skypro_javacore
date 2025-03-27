package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ProductBasket {

    private final List<Product> basket;

    public ProductBasket() {
        this.basket = new LinkedList<>();
    }

    public void add(Product product) {
        basket.add(product);
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
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            int total = 0;
            int specialPositions = 0;
            for (Product product : basket) {
                if (product != null) {
                    total += product.getPrice();
                    if (product.isSpecial()) {
                        specialPositions++;
                    }
                    System.out.println(product);
                }
            }
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

    public List<Product> remove(String name) {
        List<Product> removedElements = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element != null && element.getName().toLowerCase().contains(name.toLowerCase())) {
                removedElements.add(element);
                iterator.remove();
            }
        }
        return removedElements;
    }

}
