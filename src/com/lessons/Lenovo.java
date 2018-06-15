package com.lessons;

public class Lenovo extends AnroidPhone {
    @Override
    public void formDevice(String name, double sizeScreen, double sizeBox) {
        this.name = name;
        this.sizeScreen = sizeScreen;
        this.sizeBox = sizeBox;
        System.out.println("---------------");
        System.out.println("| "+name+" |");
        System.out.println("---------------");
        System.out.println("Screen: "+sizeScreen+ " inch");
        System.out.println("Box: "+sizeBox + " sm");


    }

    public void funRing() {
        System.out.println("Specific Lenovo`s ringtone");
    }
}