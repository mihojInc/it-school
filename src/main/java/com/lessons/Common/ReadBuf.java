package com.lessons.Common;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBuf extends Thread {
    private ObjectInputStream objIn;

    public ReadBuf(ObjectInputStream dataInputStream) {
        this.objIn = dataInputStream;

    }

    @Override
    public void run() {


    }
}
