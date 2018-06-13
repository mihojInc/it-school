package com.lessons;

public enum Commands {
    addNumber(1),
    ascOrder(2),
    descOrder(3),
    clear(4),
    exit(5);

    private final Integer code;

    Commands(Integer code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
