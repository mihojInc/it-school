package com.homeworks.phones.AndroidSeries;

import com.homeworks.phones.OperationSystem;
import com.homeworks.phones.Phone;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Android extends Phone {

    private int imai;

    OperationSystem operationSystem;

    @Override
    public void inslallOS(OperationSystem operationSystem) {
        if (operationSystem.getVersion() > 2)
            this.operationSystem = operationSystem;
    }

    @Override
    public void call(Phone phone, String speak) {
        if (operationSystem == null) {
            System.out.println("Your phone without operation system, sorry you can't call");
        } else {
            System.out.println("Speak to abonent \"" + speak + "\", and abonent speak to you \"" + phone.getVoice() + "\"");
        }
    }

    @Override
    public void sendMail(Phone phone, String message) {
        if (operationSystem == null) {
            System.out.println("Your phone without operation system, sorry you can't send message");
        } else {
            System.out.println("Send message to abonent \"" + message + "\"");
            phone.setHoldMessage(message);
        }
    }

    public int getImai() {
        return imai;
    }

    public void setImai(int imai) {
        this.imai = imai;
    }
}
