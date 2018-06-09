package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //Magazine myshop = new Magazine(5, 1000,0.2);
        //myshop.interactionWithUsers();
        Object o = new Object();
        MyListImplementation mli1 = new MyListImplementation();
        mli1.add(o);
        System.out.println(mli1.size());
        mli1.remove(0);
        System.out.println(mli1.size());

    }
}
