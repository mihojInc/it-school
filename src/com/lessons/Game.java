package com.lessons;

import java.util.Scanner;

public class Game {
    private String[] field = new String[9];

    public Game(){
        for(int i = 0; i < field.length; i++){
                field[i] = "|_|";
        }
    }

    public void showField(){
        for(int i = 0; i < field.length; i=i+3){
            System.out.println(field[i]+field[i+1]+field[i+2]);
        }
    }

    public void makeChoice(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose cell");
        if(!scan.hasNextInt()){
            System.out.println("Error");
            makeChoice();
        }
        Integer checkInt = scan.nextInt();
        if(checkInt>=0 && checkInt<=8){
            if(!field[checkInt].equals("|_|")){
                System.out.println("This cell is not empty");
                makeChoice();
            }
            field[checkInt] = "|X|";
        }else{
            System.out.println("Wrong data");
            makeChoice();
        }
    }

    public void computerChoice(){
        int a;
        do{
            a = (int) ( Math.random() * 9 );
        }while(!field[a].equals("|_|"));

        field[a] = "|0|";
    }

    public void play(){
        showField();
        if(!win()){
            makeChoice();
        }else {
            System.out.println("Computer win");
            return;
        }
        showField();
        if(!win()){
            if (!emptyCell()){
                System.out.println("No more empty cells");
                return;
            }
            System.out.println("Computer choice");
            computerChoice();
        }else {
            System.out.println("You win");
            return;
        }
        play();
    }

    public boolean win(){
        boolean win = false;
        for(int i = 0; i < 3; i++){
            if(field[i].equals(field[i+3]) && field[i].equals(field[i+6]) && !field[i].equals("|_|")){
                win = true;
            }
        }
        for(int i = 0; i < 3; i = i+3){
            if(field[i].equals(field[i+1]) && field[i].equals(field[i+2]) && !field[i].equals("|_|")){
                win = true;
            }
        }
        if(field[0].equals(field[4]) && field[0].equals(field[8]) && !field[0].equals("|_|")){
            win = true;
        }
        if(field[2].equals(field[4]) && field[2].equals(field[6]) && !field[2].equals("|_|")){
            win = true;
        }
        return win;
    }

    public boolean emptyCell(){
        boolean emptyCell = false;
        for (int i = 0; i < field.length; i++){
            if(field[i].equals("|_|")){
                emptyCell = true;
                break;
            }
        }
        return emptyCell;
    }
}
