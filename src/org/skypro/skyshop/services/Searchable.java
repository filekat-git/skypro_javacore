package org.skypro.skyshop.services;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    default String getStringRepresentation(){
        return this + " - " + this.getClass();
    }
}
