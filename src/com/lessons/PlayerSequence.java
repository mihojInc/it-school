package com.lessons;

public class PlayerSequence {
    private static long ID = 0;


    public static long getNext() {
        return ID+=1;
    }
}
