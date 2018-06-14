package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        WorkWithArray arr = new WorkWithArray(40);
        Interaction workWithArr = new Interaction(arr);
        Scanner scan = new Scanner(System.in);
        workWithArr.mainChoice(scan);

    }
}
