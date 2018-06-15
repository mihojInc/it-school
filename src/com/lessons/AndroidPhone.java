package com.lessons;

public abstract class AndroidPhone implements Phone, Os{
    /**
     * features of the Android devices class
     */

    String name = "";

    double sizeScreen = 0, sizeBox = 0;

    @Override
    public void sdUse(int card) {
        System.out.println("you are using flash drive " + card + "Gb");
    }

    @Override
    public void instAppStore(String appStore) {
        System.out.println("The installation of the AppStore applications is not supported by the system");
    }

    @Override
    public void instGooglePlay(String googlePlay) {
        System.out.println("you installed the application: "+googlePlay);
    }

    @Override
    public abstract void formDevice(String name, double sizeScreen, double sizeBox);



    @Override
    public void funRing() {
        System.out.println("Standart google ringtone");

    }

    @Override
    public void funSms(String msg) {
        System.out.println("You send this message: '"+msg+"'");

    }

}