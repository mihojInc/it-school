package com.lessons;


public class Shop {

    /**
     * var cash sets shop cash;
     * var productList sets list of products in shop;
     * var count counts how many products store in shop;
     * var margin sets margin for products in shop
     */
    private double cash;
    private Item[] productList;
    private int count;
    private double margin;

    /**
     * constructor sets shop cash and how many product can be stored in shop
     * @param cash
     * @param quantity
     */
    public Shop(double cash, double margin, int quantity){
        if(quantity<1 || margin <=0){
            throw new RuntimeException("It's forbidden");
        }
        this.cash = cash;
        this.count = 0;
        this.productList = new Item[quantity];
        this.margin = margin;
    }

    /**
     * method shows list of products
     */
    public void showProducts(){
        if(productList != null){
            System.out.print("List of products: ");
            for(int i = 0; i<count; i++){
                System.out.print(productList[i].getName() + "; ");
            }
            System.out.print("\n\n");
        }else{
            System.out.println("There is no products\n");
        }
    }

    /**
     * method shows cash size
     */
    public void showCash(){
        System.out.println("Cash is: " + cash + "\n");
    }

    /**
     * method adds product to shop
     * @param product
     */
    public void buyProduct(Item product){
        if(cash < product.getPrice()){
            System.out.println("Your cash isn't enough\n");
            return;
        }
        if(count >= productList.length){
            System.out.println("Shop is full. You can't buy more products\n");
            return;
        }
        productList[count] = product;
        cash = cash - product.getPrice();
        count++;
        System.out.println("you bought: " + product.getName());
        System.out.println("your cash is: " + cash + "\n");
    }

    /**
     * method sells product from shop
     * @param productName
     */
    public void sellProduct(String productName){
        double price = 0;
        if (productList[0] == null){
            System.out.println("Shop is empty. You can't buy anything\n");
            return;
        }
        for(Item product: productList){
            if(productName.equals(product.getName())){
                price = product.getPrice();
                cash = cash + price + price*margin;
                product = null;
                break;
            }
        }
        if(price != 0){
            System.out.println("You sold " + productName);
            System.out.println("Your cash is: " + cash + "\n");
        }else{
            System.out.println("There is no product with this name\n");
        }
    }

    public Item[] getProductList() {
        return productList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
