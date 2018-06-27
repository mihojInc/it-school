package com.lessons;

import java.util.Comparator;

public class FootballPlayerCompare implements Comparator <FootballPlayer> {
    @Override
    public int compare(FootballPlayer o1, FootballPlayer o2) {
        if(o1.getRating()<o2.getRating()) {return -1;}
        if(o1.getRating()>o2.getRating()) {return 1;}
        return 0;
    }
}
