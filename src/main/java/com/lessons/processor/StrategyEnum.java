package com.lessons.processor;

import com.lessons.answer.AnswerStrategy;
import com.lessons.answer.RandomStrategy;
import com.lessons.answer.UpseqStrategy;

public enum StrategyEnum {
    UPSEQ(new UpseqStrategy(), "upseq"),
    RAND(new RandomStrategy(), "rand");

    private AnswerStrategy strategy;
    private String strategyCode;

    StrategyEnum(AnswerStrategy strategy, String strategyCode) {
        this.strategy = strategy;
        this.strategyCode = strategyCode;
    }

    public AnswerStrategy getStrategy() {
        return strategy;
    }

    public String getStrategyCode() {
        return strategyCode;
    }

    public static StrategyEnum getStrategyByCode (String code){
        for(StrategyEnum enaum : values()){
            if (enaum.getStrategyCode().equals(code)){
                return enaum;
            }
        }
        return null;
    }
}
