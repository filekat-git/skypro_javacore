package org.skypro.skyshop.services;

import java.util.Comparator;

public class MyComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable sObj1, Searchable sObj2) {
        int lengths = Integer.compare(sObj1.getName().length(), sObj2.getName().length());
        if (lengths == 0) {
            return sObj1.getName().compareTo(sObj2.getName());
        } else {
            return lengths;
        }
    }

}
