package com.lessons.shop;

/**
 * our trade point
 */
public class Kiosk extends Shop {

    //stock of production
    StockForTenItem stock = new StockForTenItem();
    public final static int MARG = 3;


    @Override
    public void sell(Item product) {
        super.money += product.getPrice();
        stock.deleteProduct(product);
    }

    /**
     * we haven't method by show all 10 product, need see in method main.StockForTenItem.getInfoAbout
     */
    @Override
    public void addItemToStock(Item product) {

        //we sell with marg % of market prise
        double buyPrice = product.getPrice() - product.getPrice() / MARG;
        if (buyPrice < super.money) {
            super.money -= buyPrice;
            stock.addProduct(product);
        } else
            System.out.println("We haven't money from by it");

    }

    public double getPriceWithMarg(double price) {
        price -= price * MARG / 100;
        return Math.floor(price * 100) / 100;
    }

    /**
     * Show filled amount stock
     *
     * @return 0 - 10, how much items in the stock
     */
    public int getFilledStock() {
        int amount = 0;
        for (Item item : stock.getProducts())
            if (item != null)
                amount++;
        return amount;
    }
}
