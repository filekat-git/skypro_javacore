package org.skypro.skyshop.services;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable[] search(String searchTerm) {
        Searchable[] foundElements = new Searchable[5];
        int i = 0;
        for (Searchable searchableElement : searchableElements) {
            if (searchableElement != null && searchableElement.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()) && i < 5) {
                foundElements[i++] = searchableElement;
            }
            if (i == 5) {
                break;
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

    public int actualSize() {
        int i = 0;
        for (Searchable searchableElement : searchableElements) {
            if (searchableElement != null) {
                i++;
            }
        }
        return i;
    }
}
