package com.lessons;

public class Shop {
    private double cash;
//    private Product[] productList;
    private Item[] productList;
    private int count;

    public Shop(double cash, int quantity){
        if(quantity<1){
            throw new RuntimeException("It's forbidden");
        }
        this.cash = cash;
        this.count = 0;
        this.productList = new Item[quantity];
    }

    public void showProducts(){
        if(productList != null){
            System.out.print("List of products: ");
            for(int i = 0; i<count; i++){
                System.out.print(productList[i].getName() + ", ");
            }
            System.out.print("\n");
        }else{
            System.out.println("There is no products: ");
        }
    }

    public void showCash(){
        System.out.println("Cash is: " + cash);
    }

    public void buyProduct(Item product){
        if(cash < product.getPrice()){
            System.out.println("Your cash isn't enough");
            return;
        }
        if(count >= productList.length){
            System.out.println("Shop is full. You can't buy more products");
            return;
        }
        productList[count] = product;
        cash = cash - product.getPrice();
        count++;
        System.out.println("you bought: " + product.getName());
        System.out.println("your cash is: " + cash);
    }

    public void sellProduct(String productName){
        double price = 0;
        if (productList[0] == null){
            System.out.println("Shop is empty. You can't buy anything");
            return;
        }
        for(Item product: productList){
            if(productName.equals(product.getName())){
                price = product.getPrice();
                cash = cash + price;
                product = null;
                break;
            }
        }
        if(price != 0){
            System.out.println("You sold " + productName);
            System.out.println("Your cash is: " + cash);
        }else{
            System.out.println("There is no product with this name");
        }

    }
}
