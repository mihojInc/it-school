package lesson4.phop;

public class Shop {

    private Item[] goods;
    private double balance;
    private Integer count;

    Shop(Integer goodsSize, double balance){
        goods = new Item[goodsSize];
        this.balance= balance;
        count = 0;
    }

    public void buyGood(Item good){
        if(balance< good.getPrice()){
            System.out.println("Нет денег");
            return;
        }
        if (count<goods.length){
            goods[count]= good;
            balance =balance - good.getPrice();
            ++count;
            System.out.println("Наименование товара: " + good.getName() + "    Цена : " + good.getPrice() + "$ успешно добавлено");
            System.out.println("В Кассе: " + balance + "$     Количество товаров: " + count);
            System.out.println();
        } else {
            System.out.println("Нет места для твоего товара");
        }
    }
    public void sellGood(Item good){
        if (count< goods.length){
            goods[count]=good;
            balance = balance + good.getPrice();
            count = count -1;
            System.out.println("Наименование товара: " + good.getName() + "     Цена : " + good.getPrice() + "$ продан");
            System.out.println("В Кассе: " + balance + "$     Количество товаров: " + count);
        } else {
            System.out.println("Нет места для твоей позиции");
        }
    }

}


