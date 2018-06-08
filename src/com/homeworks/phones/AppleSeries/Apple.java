package com.homeworks.phones.AppleSeries;

import com.homeworks.phones.OperationSystem;
import com.homeworks.phones.Phone;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Apple extends Phone {

    private int imei;
    /**
     * all phones may default OS in time to create
     */
    private OperationSystem operationSystem = new OperationSystem(2.0);

    /**
     * all applePhones have name, by default its Apple;
     */
    private String name = "Apple";

    @Override
    public void inslallOS(OperationSystem operationSystem) {
        if (operationSystem.getVersion() >= 2) {
            this.operationSystem = operationSystem;
        }

    }

    @Override
    public void call(Phone phone, String speak) {
        String name = "unknown";
        //find name of phone
        if (!operationSystem.itsAndroid(phone)) {
            Apple apple = (Apple) phone;
            name = apple.getName();
        }
        System.out.println(speak + " - says " + this.name + " to " + name);
    }

    @Override
    public void sendMail(Phone phone, String message) {
        phone.setHoldMessage(message);
        System.out.println("Message sending");
    }

    /**
     * get some info but not to the console
     */
    public String getInfo() {
        String[] split = this.getClass().toGenericString().split("\\.");
        String model = split[split.length - 1];
        return "Model: " + model + ", size: " + getSize() + ", display: " + getDisplay() + ", memory: " + getMemory() +
                "Mb, OS version: " + operationSystem.getVersion() + ", IMEI: " + imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }
}
