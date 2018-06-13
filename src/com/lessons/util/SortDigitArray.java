package com.lessons.util;

import com.lessons.sort.MyList;

/**
 * Sort MyList by amount of digit
 */
public class SortDigitArray {

    public static MyList<Number> sort(MyList<Number> numbers) {

        System.out.println("\nThat are you wont sort array? Default sorted rise, by fall enter 'f':");
        ConsoleCommand sortedStrategy = ConsoleCommand.R;

        if (ConsoleReader.scanner.nextLine().equals(ConsoleCommand.F.getConsoleInterpritate()))
            sortedStrategy = ConsoleCommand.F;

        MyList<Number> sortList = new MyList<>();

        for (int i = 0; i <= numbers.length(); i++) {
            if (numbers.get(i) != null) {
                if (sortList.size() == 0)
                    sortList.add(numbers.get(i));
                else {
                    for (int j = 0; j < sortList.size(); j++) {
                        if ((sortList.get(j).doubleValue() > numbers.get(i).doubleValue() & sortedStrategy == ConsoleCommand.R) ||
                                sortList.get(j).doubleValue() < numbers.get(i).doubleValue() & sortedStrategy == ConsoleCommand.F) {
                            sortList.insert(j, numbers.get(i));
                            break;
                        } else if (j == sortList.size() - 1) {
                            sortList.add(numbers.get(i));
                            j++;
                        }
                    }
                }
            }
        }
        //return new sort list
        return sortList;
    }
}
