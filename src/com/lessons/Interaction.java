package com.lessons;

import com.lessons.Products.Chocolate;
import com.lessons.Products.Product;

import java.util.Scanner;

public class Interaction {
    /**
     * var createdProductList store all products? which were created;
     * var count counts how many products were created;
     * var shop sets shop to work with now;
     */
    private Item [] createdProductList;
    private int count;
    private Shop shop;

    /**
     * constructor how many product can be created and shop
     * @param limit
     * @param shop
     */
    protected Interaction(int limit, Shop shop){
        if(limit<1){
            throw new RuntimeException("It's forbidden");
        }
        this.count = 0;
        this.createdProductList = new Item[limit];
        this.shop = shop;
    }

    /**
     * method which allows to choose action user want to do
     */
    public void startChoice(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChoose action you want to do by printing the necessary word:\n");
        System.out.println("create product - print 'create'");
        System.out.println("add product to shop - print 'add'");
        System.out.println("sell product - print 'sell'");
        System.out.println("see list of products in shop - print 'shop list'");
        System.out.println("see list of created products in shop - print 'created list'");
        System.out.println("exit - print 'exit'\n");

        String checkStr = scan.nextLine();
        switch (checkStr){
            case "create":
                createProduct();
                break;
            case "created list":
                showCreatedProductList();
                break;
            case "add":
                addToShopList();
                break;
            case "shop list":
                showShopProductList();
                break;
            case "exit":
                System.out.println(Messages.EXIT.getMessage());
                break;
            default:
                System.out.println(Messages.ERROR.getMessage());
                startChoice();
                break;
        }
    }

    /**
     * method for creating new product
     */
    public void createProduct(){
        String productName;
        Double productPrice;
        Scanner scan = new Scanner(System.in);

        System.out.println("Print name of product");
        productName = scan.nextLine();

        System.out.println("Print price of product");
        String price = scan.nextLine();
        productPrice = Double.valueOf(price);

        Item product = new Product(productName, productPrice);
        addToCreatedProductList(product);

        startChoice();
    }

    /**
     * method shows all created products
     */
    public void showCreatedProductList(){
        if(createdProductList != null){
            System.out.print("List of created products: ");
            for(int i = 0; i<count; i++){
                System.out.print(createdProductList[i].getName() + "; ");
            }
            System.out.print("\n\n");
        }else{
            System.out.println("No products were created\n");
        }

        startChoice();
    }

    /**
     * method adds new created product to list of created products
     * @param product
     */
    public void addToCreatedProductList(Item product){
        if(count >= createdProductList.length){
            System.out.println("There is no more space. You can't create more products\n");
            return;
        }
        createdProductList[count] = product;
        count++;
    }


    /**
     * method add product to shop list
     * @param
     */
    public void addToShopList(){
        String name;
        String productName = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Print name of product");
        name = scan.nextLine();

        for(int i = 0; i<count; i++){
            if(name.equals(createdProductList[i].getName())){
                shop.buyProduct(createdProductList[i]);
                productName = name;
                break;
            }
        }

        if(productName == ""){
            System.out.println("There is no products with name " + name + "\n");
        }

        startChoice();
    }

    /**
     * method shows product list in shop
     */
    public void showShopProductList(){
        shop.showProducts();
        startChoice();
    }

}
