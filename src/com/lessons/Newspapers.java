package com.lessons;

/**
 * Create class Newspapers
 */
public class Newspapers implements Goodsable {
    //Fields
    private String newspapersName;
    private Double newapapersPrice;

    //Constructor
//    public Newspapers(String newspapersName, Double newapapersPrice) {
//        this.newspapersName = newspapersName;
//        this.newapapersPrice = newapapersPrice;
//    }

    /**
     * Overridden super class methods
     * @return
     */
    @Override
    public String getName() {
        return newspapersName;
    }

    @Override
    public Double getPrice() {
        return newapapersPrice;
    }

    @Override
    public String setName(String setName) {
        return newspapersName;
    }

    @Override
    public Double setPrice(Double SetPrice) {
        return newapapersPrice;
    }
}