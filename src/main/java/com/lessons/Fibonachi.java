package com.lessons;

import java.util.ArrayList;
import java.util.List;
@Description
public class Fibonachi implements MathAlgorithm{

    private  Integer first = 0;
    private  Integer second = 1;
    private  Integer sum = 0;

    @Override
    @counter(count = 20)
    public  void dolphin() {
            sum = first + second;
            second = first;
            first = sum;
            String summa = sum.toString();
            FileWork.write(summa);
    }
}
