package com.lessons;

public class ProducerRun implements Runnable{
    private Producer producer;

    public ProducerRun(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 41; i++) {
            producer.putProduct(producer.getProduct());
        }
    }
}
