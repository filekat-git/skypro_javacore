package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.services.SearchEngine;
import org.skypro.skyshop.services.Searchable;


public class App {

    public static void main(String[] args) {

        Searchable[] foundElements;
        String searchTerm;
        SearchEngine searchableElements = new SearchEngine(10);
        searchableElements.add(new SimpleProduct("Мяч футзальный", 500));
        searchableElements.add(new SimpleProduct("Мяч баскетбольный", 500));
        searchableElements.add(new DiscountedProduct("Набор мячей для тенниса", 400, 20));
        searchableElements.add(new DiscountedProduct("Мяч волейбольный", 350, 25));
        searchableElements.add(new SimpleProduct("Лента силовая", 200));
        searchableElements.add(new FixPriceProduct("Очки для плавания"));
        searchableElements.add(new SimpleProduct("Коврик для йоги", 1400));
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

        searchTerm = "мяч";
        foundElements = searchableElements.search(searchTerm);
        System.out.println("searchTerm = " + searchTerm);
        for (Searchable foundElement : foundElements) {
            if (foundElement != null) {
                System.out.println("ContentType = " + foundElement.getContentType());
                System.out.println("StringRepresentation = " + foundElement.getStringRepresentation());
            }
        }

        System.out.println();

        searchTerm = "обувь";
        foundElements = searchableElements.search(searchTerm);
        System.out.println("searchTerm = " + searchTerm);
        for (Searchable foundElement : foundElements) {
            if (foundElement != null) {
                System.out.println("ContentType = \"" + foundElement.getContentType() + "\"");
                System.out.println("StringRepresentation = " + foundElement.getStringRepresentation());
            }
        }
    }

}
