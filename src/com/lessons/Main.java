package com.lessons;

public class Main {
    /**
     * abstract class phone description model
     */
    public static void main(String[] args) {

        Samsung galaxyA7 = new Samsung();
        galaxyA7.formDevice("Galaxy A7", 5, 20);
        galaxyA7.sdUse(4);
        galaxyA7.instAppStore("MineCraft");
        galaxyA7.instGooglePlay("Skype");
        galaxyA7.funRing();
        System.out.println("*********************");
        System.out.println("");

        Lenovo a390 = new Lenovo();
        a390.formDevice("Lenovo A390",5.5, 22);
        a390.instGooglePlay("WhatsApp");
        a390.funRing();
        a390.funSms("Hi man!");
        System.out.println("*********************");
        System.out.println("");

        Iphone4 iph4 = new Iphone4();
        iph4.formDevice("IPhone 4",4,16);
        iph4.sdUse(64);
        iph4.funRing();
        iph4.instAppStore("Viber");
        System.out.println("*********************");
        System.out.println("");

    }
}
