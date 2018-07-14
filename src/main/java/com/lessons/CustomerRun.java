package com.lessons;

public class CustomerRun implements Runnable{
    private Customer customer;

    public CustomerRun(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 41; i++) {
            customer.getProduct();
        }
    }
}
