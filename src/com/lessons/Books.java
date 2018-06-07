package com.lessons;
/**
 * Class that describes Book object.
 */

public class Books implements Items{

    String bookName;

    public Books(String bookName) {
        this.bookName = bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String getName() {
        return bookName;
    }
}