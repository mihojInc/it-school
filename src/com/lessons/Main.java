package com.lessons;

import src.com.lessons.Calculate;

public class Main {

    public static void main(String[] args){
        System.out.println("Расчет последовательности Фибоначчи");
        System.out.println("-----------------------------------");
        Calculate calculate = new Calculate();
        calculate.checkInput();

    }
}
