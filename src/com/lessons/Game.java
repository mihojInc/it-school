package com.lessons;

import java.util.Scanner;

public class Game {
    Field field = new Field();

    public void play(){
        while(true){
            field.showField();
            if(!win()){
                field.makeChoice();
            }else {
                System.out.println("Computer win");
                return;
            }
            field.showField();
            if(!win()){
                if (!field.emptyCell()){
                    System.out.println("No more empty cells");
                    return;
                }
                System.out.println("Computer choice");
                field.computerChoice();
            }else {
                System.out.println("You win");
                return;
            }
        }
    }

    public boolean win(){
        boolean win = false;
        for(int i = 0; i < 3; i++){
            if(field.getField()[i].equals(field.getField()[i+3]) && field.getField()[i].equals(field.getField()[i+6]) && !field.getField()[i].equals("|_|")){
                win = true;
                return win;
            }
        }
        for(int i = 0; i < 3; i = i+3){
            if(field.getField()[i].equals(field.getField()[i+1]) && field.getField()[i].equals(field.getField()[i+2]) && !field.getField()[i].equals("|_|")){
                win = true;
                return win;
            }
        }
        if(field.getField()[0].equals(field.getField()[4]) && field.getField()[0].equals(field.getField()[8]) && !field.getField()[0].equals("|_|")){
            win = true;
            return win;
        }
        if(field.getField()[2].equals(field.getField()[4]) && field.getField()[2].equals(field.getField()[6]) && !field.getField()[2].equals("|_|")){
            win = true;
            return win;
        }
        return win;
    }


}
