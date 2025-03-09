package org.skypro.skyshop.article;

import org.skypro.skyshop.services.Searchable;

public class Article implements Searchable {

    private String name;
    private String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getContent();
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }
}
