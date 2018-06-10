package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersManager {

    public List<Integer> numberList = new ArrayList<>();

    public void setNumberList(int number) {
        numberList.add(number);
    }


    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
}
