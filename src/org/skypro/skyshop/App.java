package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;


public class App {

    public static void main(String[] args) {

        Searchable[] foundElements;
        Searchable foundElement;
        SearchEngine searchableElements = new SearchEngine(10);

        try {
            searchableElements.add(new SimpleProduct("Мяч футзальный (Мяч для футбола в зале)", 500));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new SimpleProduct("Мяч баскетбольный", 0));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new DiscountedProduct("Набор мячей для тенниса", 200, 101));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new DiscountedProduct("Мяч волейбольный", 0, 25));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new SimpleProduct("", 200));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new FixPriceProduct("Очки для плавания"));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new SimpleProduct("Коврик для йоги", 1400));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            searchableElements.add(new SimpleProduct("Сушилка для обуви", 400));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        searchableElements.add(new Article("Выбираем обувь для футбола",
                "Играть в бутсах однозначно комфортнее, чем в кроссовках. " +
                        "Форма обуви важна, чтобы чувствовать мяч " +
                        "(принимать его, двигать его и особенно бить по нему). " +
                        "Это как есть макароны ложкой – можно, но не так удобно." +
                        " Если ты с друзьями на шашлыках и решил десять минут побегать " +
                        "в футбол — нормально, в остальных ситуациях лучше бутсы."));
        searchableElements.add(new Article("Чекап здоровья перед бегом",
                "Классическая диспансеризация (в обычной поликлинике или, при возможности, " +
                        "в клинике спортивной медицины);\n" +
                        "Расширенный биохимический анализ крови с последующей расшифровкой " +
                        "от грамотного спортивного врача;\n" +
                        "Обследование вен на варикоз;\n" +
                        "Обследование сердца;\n" +
                        "Оценка состояния предыдущих травм, если такие были."));
        searchableElements.add(new Article("Что нужно купить, чтобы начать играть в большой теннис?",
                "Ракетка для тенниса;\n" +
                        "Теннисные мячи;\n" +
                        "Обувь для тенниса;\n" +
                        "Одежда для тенниса;\n" +
                        "Сумка для теннисного снаряжения."));

        System.out.println();
        System.out.println("searchableElements.actualSize() = " + searchableElements.actualSize());

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

}
