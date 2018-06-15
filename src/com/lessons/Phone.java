package com.lessons;

public interface Phone {
    /**
     * description of common phone functions
     */
    String fingerPrint = "";

    public void formDevice(String name, double sizeScreen, double sizeBox);

    public void funRing();

    public void funSms(String msg);


}
