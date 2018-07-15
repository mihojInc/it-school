package com.lessons.items;

/**
 * Created by Mihail Kolomiets on 14.07.18.
 */
public class Milk implements Item {
    private final String NAME = "milk";
    private final long MADETIME = 1000;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public long madeTime() {
        return MADETIME;
    }
}
