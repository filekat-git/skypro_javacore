package org.skypro.skyshop.services;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchableElements;

    public SearchEngine() {
        searchableElements = new ArrayList<>();
    }

    public void add(Searchable searchableElement) {
        searchableElements.add(searchableElement);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> foundElements = new ArrayList<>();
        for (Searchable searchableElement : searchableElements) {
            if (searchableElement != null && searchableElement.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundElements.add(searchableElement);
            }
        }
        return foundElements;
    }

    public Searchable searchBestResult(String searchTerm) throws BestResultNotFound {

        int maxNumberOfMatches = 0;
        Searchable bestResult = null;
        String searchableString;

        for (Searchable searchableElement : searchableElements) {

            if (searchableElement != null) {
                searchableString = searchableElement.getSearchTerm().toLowerCase();
                int count = 0;
                int index = 0;
                int indexOfMatch = searchableString.indexOf(searchTerm.toLowerCase(), index);
                while (indexOfMatch != -1) {
                    count++;
                    index = indexOfMatch + searchTerm.length();
                    indexOfMatch = searchableString.indexOf(searchTerm.toLowerCase(), index);
                }
                if (count > maxNumberOfMatches) {
                    maxNumberOfMatches = count;
                    bestResult = searchableElement;
                }
            }
        }

        if (bestResult == null) {
            throw new BestResultNotFound("Объект по поисковому запросу \"" + searchTerm + "\" не найден");
        } else {
            return bestResult;
        }

    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableElements=" + searchableElements +
                '}';
    }
}
