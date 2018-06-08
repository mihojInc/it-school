package com.homeworks.phones;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public abstract class Phone {

    /**
     * unique value of phone
     */
    private static int imei = 0;

    private double display;
    private double size;
    private int memory;

    /**
     * speak from calling
     */
    private String voice;

    /**
     * save 1 last massage from another abonents
     */
    private String holdMessage;

    public abstract void inslallOS(OperationSystem operationSystem);

    public abstract void call(Phone phone, String speak);

    public abstract void sendMail(Phone phone, String message);

    //only from create new phone
    public static int upImei() {
        imei += 1;
        return imei;
    }

    //sample read message
    public void readMessage() {
        System.out.println(getHoldMessage());
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getHoldMessage() {
        return holdMessage;
    }

    public void setHoldMessage(String holdMessage) {
        this.holdMessage = holdMessage;
    }
}
