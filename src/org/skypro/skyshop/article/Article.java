package org.skypro.skyshop.article;

import org.skypro.skyshop.services.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private final String name;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(getName(), article.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
