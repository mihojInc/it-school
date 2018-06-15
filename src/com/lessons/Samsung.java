package com.lessons;

public class Samsung extends AnroidPhone {


    @Override
    public void formDevice(String name, double sizeScreen, double sizeBox) {
        this.name = name;
        this.sizeScreen = sizeScreen;
        this.sizeBox = sizeBox;
        System.out.println("Model phone: "+name);
        System.out.println("Screen size: "+sizeScreen+ " inch");
        System.out.println("Body size: "+sizeBox + " sm");
    }



}

