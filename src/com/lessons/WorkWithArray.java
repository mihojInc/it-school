package com.lessons;

import java.util.ArrayList;

public class WorkWithArray {
    private ArrayList<Integer> array;

    WorkWithArray(){
        array = new ArrayList<Integer>(10);
    }



    public void addNumber(int num){
        this.array.add(num);
    }

    public void sortInAsc(){
        for (int size = array.size(); size != 1; --size) {
            for (int i = 0; i < size - 1; i++) {
                int temp1 = array.get(i + 1);
                int temp2 = array.get(i);
                if (temp2 > temp1) {
                    array.set(i, temp1);
                    array.set(i + 1, temp2);
                }
            }
        }

    }

    public void sortInDesc(){
        for (int size = array.size(); size != 1; --size) {
            for (int i = 0; i < size - 1; i++) {
                int temp1 = array.get(i + 1);
                int temp2 = array.get(i);
                if (temp2 < temp1) {
                    array.set(i, temp1);
                    array.set(i + 1, temp2);
                }
            }
        }
    }

    public void clear(){
        array.clear();
    }



    public void show(){
        for (int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

}
