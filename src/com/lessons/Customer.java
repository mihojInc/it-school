package com.lessons;

/**
 * Create class Customer
 */
public class Customer extends Human {
    //Fields
    private Goodsable[] goods;
    private Double money = 100d;
    private Integer qantityOfGoods = 0;

    //Constructor
    public Customer(String name, Integer age, Goodsable[] goods, Double money) {
        super(name, age);
        this.goods = goods;
        this.money = money;
    }

    /**
     * The method that buys the goods
     * @param good
     */
    public void buyGoods(Goodsable good) {
        if(good.getPrice() > money){
            System.out.println("Нет денег для покупки товара: " + good.getName());
            return;
        }
        if (qantityOfGoods < goods.length) {
            for (int i = 0; i < goods.length; i++) {
                if(goods[i] == null){
                    goods[i] = good;
                }
            }
            money -= good.getPrice();
            ++qantityOfGoods;
            System.out.println("Имя товара: " + good.getName() + " цена: " + good.getPrice() + " успешно куплен!");
            System.out.println("Общий баланс: " + money + " \n Количество товаров: " + qantityOfGoods);
        } else {
            System.out.println("Нет места для вашего товара.");
        }
    }
}

