package com.lessons.shop;

/**
 * main shops stock for save it products and gods
 */
public class StockForTenItem {

    /**
     * capacity 10 item only stock
     */
    private Item[] products = new Item[10];

    /**
     * find item by its name
     *
     * @param name unique for all item
     * @return directly Item
     */
    public Item getProductByName(String name) {

        for (Item product : products) {
            if (product != null && product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    /**
     * delete production items in stock
     *
     * @param product deleting Item
     */
    public void deleteProduct(Item product) {

        for (int i = 0; i < 10; i++) {
            if (products[i] != null)
                if (products[i].equals(product)) {
                    products[i] = null;

                    //for exit
                    i = 10;
                }
        }
    }

    public void addProduct(Item item) {


        for (int i = 0; i < 10; i++) {

            if (products[i] == null) {
                products[i] = item;

                //see previous method why
                i = 10;
            }

            if (i == 9)
                System.out.println("Stock is full, sorry.Sell gods!");
        }
    }

    /**
     * send info about stock items and they price in console
     */
    public void getInfoAbout() {

        for (Item product : products) {
            if (product != null && !product.getName().equals("no name"))
                System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    public Item[] getProducts() {
        return products;
    }
}
