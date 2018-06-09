package com.homeworks.phoneShop;

import com.homeworks.phones.AppleSeries.Apple;
import com.homeworks.phones.Phone;
import com.lessons.shop.Item;

/**
 * Convert exist model to Item for put in stock
 */
public class PhoneItems implements Item {

    private Phone phone;
    private String name = "unknown";
    private double price;

    /**
     * @param phone - new instance of Phone
     * @param price - how much it cost
     */
    public PhoneItems(Phone phone, double price) {
        this.phone = phone;
        this.price = price;

        //get name of phone if it's an Apple series
        if (phone instanceof Apple) {
            name = ((Apple) phone).getName();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
