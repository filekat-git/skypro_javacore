package org.skypro.skyshop.services;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return "\"" + getSearchTerm() + "\" - \"" + getContentType() + "\"";
    }
}
