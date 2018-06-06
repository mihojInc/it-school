package com.lessons;

public class Customer {
    private double moneyLimit;
    private Item[] boughtProducts;
    private int count;

    /**
     * constructor sets limit of customer money and limit of products
     * @param moneyLimit
     * @param size
     */
    public Customer(double moneyLimit, int size){
        if(size<1){
            throw new RuntimeException("It's forbidden");
        }
        this.moneyLimit = moneyLimit;
        this.count = 0;
        this.boughtProducts = new Item[size];
    }

    /**
     * method shows list of products
     */
    public void customerProducts(){
        if(boughtProducts != null){
            System.out.print("List of bought products: ");
            for(int i = 0; i<count; i++){
                System.out.print(boughtProducts[i].getName() + "; ");
            }
            System.out.print("\n\n");
        }else{
            System.out.println("There is no products\n");
        }
    }

    /**
     * method for buying products and adding them to product list
     * @param product
     */
    public void buyProduct(Item product){
        if(moneyLimit < product.getPrice()){
            System.out.println("You don't have enough money\n");
            return;
        }
        if(count >= boughtProducts.length){
            System.out.println("You can't buy more products\n");
            return;
        }
        boughtProducts[count] = product;
        moneyLimit = moneyLimit - product.getPrice();
        count++;
        System.out.println("you bought: " + product.getName());
        System.out.println("rest of your money is: " + moneyLimit + "\n");
    }
}
