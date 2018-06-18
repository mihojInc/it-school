package com.lessons;

import java.util.Comparator;

/**
 * Comparator for sorting football players by rating
 */
public class SortByRating implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getRating()>= o2.getRating()){
            return 1;
        }else{
            return -1;
        }

    }
}
