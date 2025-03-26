package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;
import java.util.List;


public class App {

    public static ProductBasket basket;
    public static SearchEngine searchableElements;
    public static List<Product> removedProducts;

    public static void main(String[] args) {

        createElementsAndFillCollections();

        System.out.println("Демонстрация корзины");
        basket.printBasket();
        System.out.println("basket.totalPrice() = " + basket.totalPrice());
        System.out.println("basket.isProductInBasket(\"Коврик для йоги\") = " + basket.isProductInBasket("Коврик для йоги"));
        System.out.println("basket.isProductInBasket(\"Томат\") = " + basket.isProductInBasket("Томат"));
        removedProducts = basket.remove("мяч");
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        } else {
            System.out.println(removedProducts);
        }
        removedProducts = basket.remove("огурец");
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        } else {
            System.out.println(removedProducts);
        }
        basket.printBasket();

        System.out.println("Демонстрация поиска");
        System.out.println("searchableElements = " + searchableElements);

        List<Searchable> foundElements;
        Searchable foundElement;

        String[] searchTerms = {"мяч", "обувь", "hello"};
        for (String searchTerm : searchTerms) {
            System.out.println();
            System.out.println("searchTerm = " + searchTerm);
            foundElements = searchableElements.search(searchTerm);
            System.out.println();
            System.out.println("searchableElements.search(searchTerm) method");
            for (Searchable s : foundElements) {
                if (s != null) {
                    System.out.println();
                    System.out.println("ContentType = " + s.getContentType());
                    System.out.println("StringRepresentation = " + s.getStringRepresentation());
                }
            }

            try {
                System.out.println();
                System.out.println("searchableElements.searchBestResult(searchTerm) method");
                foundElement = searchableElements.searchBestResult(searchTerm);
                System.out.println();
                System.out.println("foundElement = " + foundElement);
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createElementsAndFillCollections() {

        basket = new ProductBasket();
        searchableElements = new SearchEngine();

        try {
            Product p1 = new SimpleProduct("Мяч футзальный (Мяч для футбола в зале)", 500);
            basket.add(p1);
            searchableElements.add(p1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p2 = new SimpleProduct("Мяч баскетбольный", 0);
            basket.add(p2);
            searchableElements.add(p2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p3 = new DiscountedProduct("Набор мячей для тенниса", 200, 101);
            basket.add(p3);
            searchableElements.add(p3);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p4 = new DiscountedProduct("Мяч волейбольный", 0, 25);
            basket.add(p4);
            searchableElements.add(p4);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p5 = new SimpleProduct("", 200);
            basket.add(p5);
            searchableElements.add(p5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p6 = new FixPriceProduct("Мяч волейбольный");
            basket.add(p6);
            searchableElements.add(p6);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p7 = new SimpleProduct("Коврик для йоги", 1400);
            basket.add(p7);
            searchableElements.add(p7);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Product p8 = new SimpleProduct("Сушилка для обуви", 400);
            basket.add(p8);
            searchableElements.add(p8);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Article a1 = new Article("Выбираем обувь для футбола",
                    "Играть в бутсах однозначно комфортнее, чем в кроссовках. " +
                            "Форма обуви важна, чтобы чувствовать мяч " +
                            "(принимать его, двигать его и особенно бить по нему). " +
                            "Это как есть макароны ложкой – можно, но не так удобно." +
                            " Если ты с друзьями на шашлыках и решил десять минут побегать " +
                            "в футбол — нормально, в остальных ситуациях лучше бутсы.");
            searchableElements.add(a1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Article a2 = new Article("Чекап здоровья перед бегом",
                    "Классическая диспансеризация (в обычной поликлинике или, при возможности, " +
                            "в клинике спортивной медицины);\n" +
                            "Расширенный биохимический анализ крови с последующей расшифровкой " +
                            "от грамотного спортивного врача;\n" +
                            "Обследование вен на варикоз;\n" +
                            "Обследование сердца;\n" +
                            "Оценка состояния предыдущих травм, если такие были.");
            searchableElements.add(a2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            Article a3 = new Article("Что нужно купить, чтобы начать играть в большой теннис?",
                    "Ракетка для тенниса;\n" +
                            "Теннисные мячи;\n" +
                            "Обувь для тенниса;\n" +
                            "Одежда для тенниса;\n" +
                            "Сумка для теннисного снаряжения.");
            searchableElements.add(a3);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

    }


}
