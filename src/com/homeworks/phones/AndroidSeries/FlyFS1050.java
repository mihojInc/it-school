package com.homeworks.phones.AndroidSeries;

import com.homeworks.phones.OperationSystem;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class FlyFS1050 extends Android {

    private String color = "black";

    /**
     * By default FS1050 is black color ang default OS 1.0
     */
    public FlyFS1050() {
        setSize(5.4);
        setMemory(2000);
        setDisplay(5);
        operationSystem = new OperationSystem(1.0);
        setImai(upImei());
    }

    public FlyFS1050(String color) {
        this();
        this.color = color;
    }

    /**
     * phone may say information by himself
     */
    public void getInfoAboutPhone() {
        System.out.println("Fly Fs1050 - color " + color + " - size " + getSize() + " - display " + getDisplay() +
                " - memory " + getMemory() + "Mb - OS version " + operationSystem.getVersion() + " - IMEI " + getImai());
    }

}
