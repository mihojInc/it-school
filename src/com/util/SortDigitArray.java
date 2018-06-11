package com.util;

import com.sort.MyList;

/**
 * Sort MyList by amount of digit
 */
public class SortDigitArray {

    public static MyList<Number> sort(MyList<Number> numbers) {

        MyList<Number> sortList = new MyList<>();

        // get all digit
        for (int i = 0, noNullDigits = 0; noNullDigits < numbers.size(); i++) {
            if (numbers.get(i) != null) {

                //and put into new list
                if (noNullDigits == 0) {
                    sortList.add(numbers.get(i));
                } else {

                    //compare with exist numbers in new list
                    for (int j = 0; j < sortList.size(); j++) {
                        if (sortList.get(j).doubleValue() > numbers.get(i).doubleValue()) {

                            Number number = sortList.get(j);
                            Number number2;
                            sortList.add(j, numbers.get(i));

                            //and insert with shifting into him
                            boolean exit = true;
                            int m = j;
                            do {
                                number2 = sortList.get(m + 1);
                                sortList.add(m + 1, number);
                                number = number2;

                                if (sortList.get(m + 2) == null) {
                                    sortList.add(m + 2, number);
                                    exit = false;
                                }
                                m++;
                            } while (exit);
                            break;
                        } else if (j == sortList.size() - 1) {
                            sortList.add(numbers.get(i));
                            break;
                        }
                    }
                }
                noNullDigits++;
            }
        }

        //return new sort list
        return sortList;
    }
}
