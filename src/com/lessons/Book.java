package com.lessons;

/**
 * Create class Book
 */
public class Book implements Goodsable{
    //Fields
    private String bookName;
    private Double bookPrice;

    //Constructor
//    public Book(String bookName, Double bookPrice) {
//        this.bookName = bookName;
//        this.bookPrice = bookPrice;
//    }

    /**
     * Overridden super class methods
     *
     * @return
     */
    @Override
    public String getName() {
        return this.bookName;
    }

    @Override
    public Double getPrice() {
        return this.bookPrice;
    }

    @Override
    public String setName(String setName) {
        return bookName;
    }

    @Override
    public Double setPrice(Double setPrice) {
        return bookPrice;
    }
}
