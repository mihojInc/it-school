package com.lessons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private final String REGEX = "([\\w+\\-.]{1,}@[\\w+]{1,}[\\.]{1}[\\w+]{2,4})";
    private final String INPUT = "Good afternoon! I want to use my regular expression to find my mail " +
                                 " thunderstorm.lightning@inbox.ru It can be anything!";

    public void regex() {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);

        if(matcher.find()){
            System.out.println("I found my mail: " + matcher.group(0));
        } else {
            System.out.println("The regular expression is not correct!");
        }
    }
}
