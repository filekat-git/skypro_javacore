package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket(5);

        basket.addProduct(new Product("tomato", 500));
        basket.addProduct(new Product("cucumber", 400));
        basket.addProduct(new Product("pepper", 350));
        basket.addProduct(new Product("olive_oil", 1500));
        basket.addProduct(new Product("brine_cheese", 250));

        basket.addProduct(new Product("olives", 400));

        System.out.println();
        basket.printBasket();

        System.out.println();
        System.out.println("Стоимость корзины: " + basket.totalPrice());

        System.out.println();
        System.out.println(basket.isProductInBasket("cucumber") ? "Товар найден" : "Товар НЕ найден");

        System.out.println();
        System.out.println(basket.isProductInBasket("olives") ? "Товар найден" : "Товар НЕ найден");

        System.out.println();
        basket.clearBasket();
        basket.printBasket();

        System.out.println();
        System.out.println("Стоимость корзины: " + basket.totalPrice());

        System.out.println();
        System.out.println(basket.isProductInBasket("tomato") ? "Товар найден" : "Товар НЕ найден");

    }
}
