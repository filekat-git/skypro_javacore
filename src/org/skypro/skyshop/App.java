package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket(5);

        basket.addProduct(new SimpleProduct("tomato", 500));
        basket.addProduct(new DiscountedProduct("cucumber", 400, 20));
        basket.addProduct(new DiscountedProduct("pepper", 350, 25));
        basket.addProduct(new SimpleProduct("olive_oil", 1500));
        basket.addProduct(new FixPriceProduct("brine_cheese"));

        basket.addProduct(new SimpleProduct("olives", 400));

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
