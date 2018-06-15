package com.lessons;

public enum Commands {
    addNumber(1,"To add new number to array enter 1"),
    ascOrder(2,"To sort array in asc order enter 2"),
    descOrder(3,"To sort array in desc order enter 3"),
    clear(4,"To clear array enter 4"),
    exit(5,"To exit enter 5");

    private final Integer code;
    private String instruction;

    Commands(Integer code, String instr){
        this.code = code;
        this.instruction = instr;
    }

    public int getCode() {
        return code;
    }

    public String getInstruction() {
        return instruction;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
