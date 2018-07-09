package com.lessons.processor;

import java.util.function.BiFunction;

enum MathEnum {
    PLUS((aLong, aLong2) -> aLong+aLong2, "+"),
    MINUS((aLong, aLong2) -> aLong - aLong2, "-"),
    MULTIPLY((aLong, aLong2) -> aLong * aLong2, "*"),
    DIVIDE((aLong, aLong2) -> aLong / aLong2, "/");

    private BiFunction<Long, Long, Long> function;
    private String operation;

    MathEnum(BiFunction<Long, Long, Long> function, String operation) {
        this.function = function;
        this.operation = operation;
    }

    public BiFunction<Long, Long, Long> getFunction() {
        return function;
    }

    public void setFunction(BiFunction<Long, Long, Long> function) {
        this.function = function;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public static BiFunction getFunctionByOperation(String operation) {
        for (MathEnum mathEnum : values()) {
            if (mathEnum.getOperation().equals(operation)) {
                return mathEnum.getFunction();
            }
        }
        return null;
    }
}