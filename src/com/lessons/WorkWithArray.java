package com.lessons;

import java.util.Scanner;

public class WorkWithArray {
    private Integer[] mainArray;
    private int count;

    public WorkWithArray(int size){
        this.mainArray = new Integer[size];
        this.count = 0;
    }

    public void addNumber(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter numbers. Max quantity of numbers is " + mainArray.length);

        if(!scan.hasNextInt()){
            System.out.println(Messages.ERROR);
            addNumber();
        }

        if(count>mainArray.length){
            System.out.println("Array is full. You can't add any more numbers");
            return;
        }

        mainArray[count] = scan.nextInt();
        count++;
    }

    public void showSortToMax(){
        Integer[] maxArray = sortToMax();
        System.out.print("Array sorted to max: ");
        for(int i = 0; i<maxArray.length; i++){
            if(maxArray[i] != null){
                System.out.print(maxArray[i] + " ");
            }
        }
        System.out.print("\n");
    }

    public void showSortToMin(){
        Integer[] maxArray = sortToMin();
        System.out.print("Array sorted to min: ");
        for(int i = 0; i<maxArray.length; i++){
            if(maxArray[i] != null){
                System.out.print(maxArray[i] + " ");
            }
        }
        System.out.print("\n");
    }

    public Integer[] sortToMax(){
        Integer[] maxArr = mainArray.clone();
        for(int i = 0; i < maxArr.length; i++){
            if(maxArr[i] !=null) {
                int min = maxArr[i];
                for(int m = i; m < maxArr.length; m++){
                    if(maxArr[m] !=null && maxArr[m]<min){
                        min = maxArr[m];
                    }
                }

                for(int k = 0; k < maxArr.length; k++){
                    if(maxArr[k] !=null && maxArr[k] == min){
                        maxArr[k] = maxArr[i];
                        break;
                    }
                }
                maxArr[i] = min;
            }
        }
        return maxArr;
    }

    public Integer[] sortToMin(){
        Integer[] minArr = mainArray.clone();
        for(int i = 0; i < minArr.length; i++){
            if(minArr[i] !=null){
                int max = minArr[i];
                for(int m = i; m < minArr.length; m++){
                    if(minArr[m] !=null && minArr[m]>max){
                        max = minArr[m];
                    }
                }

                for(int k = 0; k < minArr.length; k++){
                    if(minArr[k] !=null && minArr[k] == max){
                        minArr[k] = minArr[i];
                        break;
                    }
                }

                minArr[i] = max;
            }
        }
        return minArr;
    }

    public void clear(){
        for(Integer num: mainArray){
            num = null;
        }
    }

}
