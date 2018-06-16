package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Functionality functionality = new Functionality();
        Interaction interaction = new Interaction(functionality);
        Scanner scan = new Scanner(System.in);
        interaction.mainChoice(scan);
    }
}
