package lesson4.phop;

public class Buyer {

    private Item[] list ;
    private int money ;
    private Integer count1;

    Buyer(Integer goodsList, int money){
        list = new Item[goodsList];
        this.money = money;
        count1 = 0;
    }
}
