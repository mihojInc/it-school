package com.lessons.processor;

import com.lessons.App;

public abstract class AbstractProcessor {


    protected AbstractProcessor next;

    public AbstractProcessor(AbstractProcessor next){
        this.next = next;
    }

    public abstract boolean proccess(String line, App app);
}
