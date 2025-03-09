package org.skypro.skyshop.services;

public class SearchEngine {

    private Searchable[] searchableElements;

    public SearchEngine(int size) {
        searchableElements = new Searchable[size];
    }

    public void add(Searchable searchableElement) {
        for (int i = 0; i < searchableElements.length; i++) {
            if (searchableElements[i] == null) {
                searchableElements[i] = searchableElement;
                break;
            }
        }
    }

    public Searchable[] search(String searchTerm){
        Searchable[] foundElements = new Searchable[5];
        int i = 0;
        for (Searchable searchableElement : searchableElements) {
            if (searchableElement.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()) && i < 5) {
                foundElements[i++] = searchableElement;
            }
            if (i==5) {
                break;
            }
        }
        return foundElements;
    }

}
