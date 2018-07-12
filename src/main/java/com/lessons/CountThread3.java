package com.lessons;

public class CountThread3 implements Runnable {

    Resource2 res;

    CountThread3(Resource2 res) {
        this.res = res;
    }

    public void run() {
        res.increment();
    }
}
