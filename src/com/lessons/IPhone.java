package com.lessons;

public abstract class IPhone implements Phone, Os {
    /**
     * features of the Iphone`s class
     */
    boolean appOs = true;
    String name = "";
    double sizeScreen = 0, sizeBox = 0;

    @Override
    public void sdUse(int card) {
        System.out.println("this phone doesn`t support sd-card");

    }

    @Override
    public void instAppStore(String appStore) {
        System.out.println("you installed the application: "+appStore);
    }

    @Override
    public void instGooglePlay(String googlePlay) {
        System.out.println("The installation of the Google applications is not supported by the system");
    }

    @Override
    public void formDevice(String name, double sizeScreen, double sizeBox) {

    }

    @Override
    public void funRing() {
        System.out.println("Standart Apple ringtone");
    }

    @Override
    public void funSms(String msg) {
        System.out.println("You send this message: '"+msg+"'");

    }
}

