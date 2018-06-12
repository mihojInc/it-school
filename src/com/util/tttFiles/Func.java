package com.util.tttFiles;

import com.collection.MyList;

import java.util.Scanner;

/**
 * Func for game
 */
public class Func {

    /**
     * Write to console all Field by his status
     */
    public void getFieldDesk() {
        String fild = Field.ZERO.getFildByStatement() + Field.ONE.getFildByStatement() + Field.TWO.getFildByStatement() + "\n" +
                Field.THREE.getFildByStatement() + Field.FOUR.getFildByStatement() + Field.FIVE.getFildByStatement() + "\n" +
                Field.SIX.getFildByStatement() + Field.SEVEN.getFildByStatement() + Field.EIGTH.getFildByStatement();
        System.out.println(fild);
    }

    /**
     * Check all win combinations
     *
     * @return true if combinations d't coincided
     */
    public boolean chekWin() {
        if ((Field.ZERO.getStatementsField() == StatementsField.WITHX & Field.ONE.getStatementsField() == StatementsField.WITHX & Field.TWO.getStatementsField() == StatementsField.WITHX) ||
                (Field.THREE.getStatementsField() == StatementsField.WITHX & Field.FOUR.getStatementsField() == StatementsField.WITHX & Field.FIVE.getStatementsField() == StatementsField.WITHX) ||
                (Field.SIX.getStatementsField() == StatementsField.WITHX & Field.SEVEN.getStatementsField() == StatementsField.WITHX & Field.EIGTH.getStatementsField() == StatementsField.WITHX) ||
                (Field.ZERO.getStatementsField() == StatementsField.WITHX & Field.THREE.getStatementsField() == StatementsField.WITHX & Field.SIX.getStatementsField() == StatementsField.WITHX) ||
                (Field.FOUR.getStatementsField() == StatementsField.WITHX & Field.ONE.getStatementsField() == StatementsField.WITHX & Field.SEVEN.getStatementsField() == StatementsField.WITHX) ||
                (Field.FIVE.getStatementsField() == StatementsField.WITHX & Field.EIGTH.getStatementsField() == StatementsField.WITHX & Field.TWO.getStatementsField() == StatementsField.WITHX) ||
                (Field.ZERO.getStatementsField() == StatementsField.WITHX & Field.FOUR.getStatementsField() == StatementsField.WITHX & Field.EIGTH.getStatementsField() == StatementsField.WITHX) ||
                (Field.SIX.getStatementsField() == StatementsField.WITHX & Field.FOUR.getStatementsField() == StatementsField.WITHX & Field.TWO.getStatementsField() == StatementsField.WITHX)) {
            System.out.println("You win");
            return false;
        } else if ((Field.ZERO.getStatementsField() == StatementsField.WITH0 & Field.ONE.getStatementsField() == StatementsField.WITH0 & Field.TWO.getStatementsField() == StatementsField.WITH0) ||
                (Field.THREE.getStatementsField() == StatementsField.WITH0 & Field.FOUR.getStatementsField() == StatementsField.WITH0 & Field.FIVE.getStatementsField() == StatementsField.WITH0) ||
                (Field.SIX.getStatementsField() == StatementsField.WITH0 & Field.SEVEN.getStatementsField() == StatementsField.WITH0 & Field.EIGTH.getStatementsField() == StatementsField.WITH0) ||
                (Field.ZERO.getStatementsField() == StatementsField.WITH0 & Field.THREE.getStatementsField() == StatementsField.WITH0 & Field.SIX.getStatementsField() == StatementsField.WITH0) ||
                (Field.FOUR.getStatementsField() == StatementsField.WITH0 & Field.ONE.getStatementsField() == StatementsField.WITH0 & Field.SEVEN.getStatementsField() == StatementsField.WITH0) ||
                (Field.FIVE.getStatementsField() == StatementsField.WITH0 & Field.EIGTH.getStatementsField() == StatementsField.WITH0 & Field.TWO.getStatementsField() == StatementsField.WITH0) ||
                (Field.ZERO.getStatementsField() == StatementsField.WITH0 & Field.FOUR.getStatementsField() == StatementsField.WITH0 & Field.EIGTH.getStatementsField() == StatementsField.WITH0) ||
                (Field.SIX.getStatementsField() == StatementsField.WITH0 & Field.FOUR.getStatementsField() == StatementsField.WITH0 & Field.TWO.getStatementsField() == StatementsField.WITH0)) {
            System.out.println("You lose");
            return false;
        }
        return true;
    }

    public void cpuStep() {

        System.out.println("Cpu step:");

        //find empty fields
        MyList<Field> emptyFields = new MyList<>();
        for (Field field : Field.values())
            if (field.getStatementsField() == StatementsField.EMPTY) {
                emptyFields.add(field);
            }

        int countEmptyFiels = emptyFields.size();

        if (countEmptyFiels == 0) {
            System.out.println("No steps. Nobody win.");

        } else {
            // 0.99 need for avoid null pointer exception
            int random = (int) Math.floor(Math.random() * countEmptyFiels * 0.99);
            emptyFields.get(random).setStatementsField(StatementsField.WITH0);
        }
    }

    /**
     * @param scanner - from control filed number (0-8)
     */
    public void playerStep(Scanner scanner) {
        boolean filesSet = false;

        System.out.println("You step:");

        do {
            try {
                int input = Integer.valueOf(scanner.nextLine());

                if (input < 0 | input > 8) {
                    System.out.println(input + " not a fild, sorry. Try 0 - 8.");

                } else if (Field.values()[input].getStatementsField() != StatementsField.EMPTY) {
                    System.out.println("Field " + input + " is d't empty.");

                } else {
                    Field.values()[input].setStatementsField(StatementsField.WITHX);
                    filesSet = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("It's not a number, try again");
            }

        } while (!filesSet);
    }


}
