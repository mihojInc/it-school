package com.lessons.items;

/**
 * Created by Mihail Kolomiets on 14.07.18.
 */
public class Fish implements Item {
    private final String NAME = "a fish";
    private final long MADETIME = 2000;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public long madeTime() {
        return MADETIME;
    }
}
