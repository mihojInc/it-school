package com.lessons.shop;

/**
 * any costumer for buying in our shop
 */
public class Costumer implements Purchase {

    private String name;
    private double money;

    // costumer can carry only 5 gods
    private Item[] shoppingCart = new Item[5];

    //without empty constructor because all human have a name
    public Costumer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public void buy(Item item) {
        if (item.getPrice() > money)
            System.out.println(name + " haven't money for buy " + item.getName());
        else if (countGodsInCart() > 5)
            System.out.println("You cart is full.");
        else {

            //add item into the cart
            for (int i = 0; i < shoppingCart.length; i++) {
                if (shoppingCart[i] == null) {
                    shoppingCart[i] = item;
                    money -= item.getPrice();
                    break;
                }
            }

        }
    }

    /**
     * easy counter purchased gods
     *
     * @return amount gods in cart
     */
    private int countGodsInCart() {
        int count = 5;
        for (Item item : shoppingCart)
            if (item == null)
                count--;
        return count;
    }

    /**
     * Show info for console about items into the carts, like : bread water ...
     */
    public void getInfoAboutCart() {
        if (countGodsInCart() == 0) {
            System.out.println("Cart is empty.");
        } else {
            String items = "";
            for (Item item : shoppingCart)
                if (item != null)
                    items += " " + item.getName();
            System.out.println("It is " + countGodsInCart() + " items in cart: " + items);
        }
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
