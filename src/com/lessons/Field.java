package com.lessons;

import java.util.Scanner;

public class Field {
    private String[] field = new String[9];

    public Field(){
        for(int i = 0; i < field.length; i++){
            field[i] = "|_|";
        }
    }

    public void showField(){
        for(int i = 0; i < field.length; i=i+3){
            System.out.println(field[i]+field[i+1]+field[i+2]);
        }
    }

    public String[] getField() {
        return field;
    }

    public void makeChoice(){
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Choose cell");

            while (!scan.hasNextInt()) {
                System.out.println("Error");
                scan.next();
            }
            Integer checkInt = scan.nextInt();
            if(checkInt>=0 && checkInt<=8){
                if(!field[checkInt].equals("|_|")){
                    System.out.println("This cell is not empty");
                }else{
                    field[checkInt] = "|X|";
                    break;
                }
            }else{
                System.out.println("Wrong data");
            }
        }

    }

    public void computerChoice(){
        int a;
        do{
            a = (int) ( Math.random() * 9 );
        }while(!field[a].equals("|_|"));

        field[a] = "|0|";
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
