package com.lessons;

import java.util.Scanner;

/**
 * Class describe behavour array
 */
public class ArrayMy {

    /**
     * Array wich conteins from int number
     */
    private int [] array;
    /**
     * Cuurent size of array
     */
    private int curPos = 0;

    /**
     * this procedure adds number to array
     * @param num number for aadd to array
     */
    public void add(int num){
        if (curPos == array.length){
            System.out.println("Dont have place in array");
            return;

        }

        array[curPos++] = num;
    }

    /**
     * this procedure clear array
     *
     */
    public void clear(){
        for (int i=0;i<array.length;i++){
            array[i] = 0;
        }
        curPos = 0;
    }
    /**
     * this procedure sort array by Bubble Sort
     *
     */
    public void sortBubl(boolean dir){

        if (curPos == 0){
            System.out.println("Array is empty");
            return;
        }


        int help;

        for (int i=0; i<array.length;i++){
            for (int k=0; k<array.length;k++){
                if(dir){

                    if(array[i]<array[k]){
                        help = array[i];
                        array[i] = array[k];
                        array[k] = help;
                    }

                } else
                {
                    if(array[i]>array[k]) {
                        help = array[i];
                        array[i] = array[k];
                        array[k] = help;
                    }
                }
            }
        }
    }
    /**
     * this procedure sort array by Incert Sort
     *
     */
    public void sortIncert(boolean dir){

        if (curPos == 0){
            System.out.println("Array is empty");
            return;
        }

        int min = array[0], posMin = 0;
        int curSort = 0;

        if(dir){

            while(curSort!=array.length){
                min = array[curSort];
                for (int i=curSort; i<array.length;i++){
                    if (array[i]<min){
                        min = array[i];
                        posMin = i;
                    }
                }

                int help = array[curSort];
                array[curSort] = array[posMin];
                array[posMin] = help;

                curSort++;
            }
        }
        else {
            while(curSort!=array.length){
                min = array[curSort];
                for (int i=curSort; i<array.length;i++){
                    if (array[i]>min){
                        min = array[i];
                        posMin = i;
                    }
                }

                int help = array[curSort];
                array[curSort] = array[posMin];
                array[posMin] = help;

                curSort++;
            }
        }

    }

    ArrayMy(int size) {
        array = new int[size];
    }

    /**
     * this procedure out number in array
     *
     */
    public void list(){

        for(int ar:array) System.out.print(ar + " ");
        System.out.print("\n");
    }
}
