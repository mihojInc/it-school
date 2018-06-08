package com.homeworks.phones;

import com.homeworks.phones.AndroidSeries.FlyFS1050;
import com.homeworks.phones.AppleSeries.Apple7;
import com.homeworks.phones.AppleSeries.SuperIphone;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 */
public class Main {
    public static void main(String[] args) {

        //create phones
        FlyFS1050 flyFS1050 = new FlyFS1050();
        FlyFS1050 fly = new FlyFS1050("red");
        Apple7 apple7 = new Apple7();
        SuperIphone iphone = new SuperIphone();

        //get info about phones
        flyFS1050.getInfoAboutPhone();
        fly.getInfoAboutPhone();
        System.out.println(iphone.getInfo());

        //phones calling
        apple7.call(iphone, "Hello");
        fly.call(apple7, "Hi");

        flyFS1050.setVoice("I am fine, thank you!");
        fly.call(flyFS1050, "How are you?");

        //messaging
        apple7.sendMail(fly, "That is you IMEI?");
        //fly show mail
        fly.readMessage();
        fly.sendMail(apple7, fly.getImai() + "");
    }
}
