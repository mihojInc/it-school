package com.lessons.items;

/**
 * Created by Mihail Kolomiets on 14.07.18.
 */
public class Meat implements Item{
    private final String NAME = "meat";
    private final long MADETIME = 1500;
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public long madeTime() {
        return MADETIME;
    }
}
