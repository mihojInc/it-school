package com.lessons.processor;

import com.lessons.App;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lessons.processor.MathEnum.getFunctionByOperation;

public class MathProcessor extends AbstractProcessor {

    private static final String COMMAND_START = "Посчитай:";

    private static final Pattern PATTERN = Pattern.compile("([\\s]{0,}[0-9]{1,}[\\s]{0,})([+\\-*/])([\\s]{0,}[0-9]{1,}[\\s]{0,})");

    public MathProcessor(AbstractProcessor next) {
        super(next);
    }

    @Override
    public boolean proccess(String line, App app) {
        if (line.startsWith(COMMAND_START)) {
            Matcher matcher = PATTERN.matcher(line.split(COMMAND_START)[1]);
            if (matcher.find()) {
                Long firstNumber = Long.parseLong(matcher.group(1).trim());
                Long secondNumber = Long.parseLong(matcher.group(3).trim());
                String operation = matcher.group(2);
                System.out.println("Господин, я посчитал: " + getFunctionByOperation(operation).apply(firstNumber, secondNumber));
                return true;
            } else {
                System.out.println("Я не могу посчитать такую хню)");
                return true;
            }
        }
        if (next == null) {
            return false;
        }
        return next.proccess(line, app);
    }
}
