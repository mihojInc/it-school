package com.lessons.processor;

import com.lessons.App;

public class ChangeStrategyProcessor extends AbstractProcessor {


    private final static String COMMAND = "Измени:";

    public ChangeStrategyProcessor(AbstractProcessor next) {
        super(next);
    }

    @Override
    public boolean proccess(String line, App app) {
        if(line.startsWith(COMMAND)){
            String command = line.trim().split(COMMAND)[1].trim();
            StrategyEnum strategyEnum = StrategyEnum.getStrategyByCode(command);
            if (strategyEnum!=null){
                app.getPrinter().setAnswerStrategy(strategyEnum.getStrategy());
                System.out.println("Стратегия ответов установленна, хозяин!");
            }else {
                System.out.println("Такой стратегии нет(");
            }
            return true;
        }
        if (next == null){
            return false;
        }
        return next.proccess(line, app);
    }
}
