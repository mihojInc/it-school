package lesson4.phop;

/* этот клас модель покупателя, которая описывает параметры и методы покупателя*/

public class Buyer {

    private Item[] list ;
    private double money ;
    private Integer count1;
    private double marga;
    private String[] listGods;

    Buyer(Integer goodsList, double money, double marga){
        list = new Item[goodsList];
        this.money = money;
        this.marga = marga;
        listGods =new  String[goodsList];
        count1 = 0;
    }
    public Item[] getList() {
        return list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getCount1() {
        return count1;
    }

    public void setCount1(Integer count1) {
        this.count1 = count1;
    }
// метод совершения покупки покупателем и вывод на консоль

    public void sellGood(Item good){
        if (money< good.getPrice()) {
            System.out.println("У вас не достаточно денег для совершения покупки!");
            return;
        }
        if (count1<list.length) {
            list[count1] = good;
            money = money - (good.getPrice()* marga);
            ++count1;
            for (int i=0; i<listGods.length;i++){
                if (listGods[i] == null){
                    listGods[i]= good.getName();
                    break;
                }
            }

            System.out.println("Вы купили: " + good.getName() + "     Цена : " + (good.getPrice()* marga  ) + "$");
            System.out.println("В кошельке: " + money + "$    В сумке: " + count1 + " товар(a)");
            System.out.println( "                      а именно : " );
            for (int i =0; i<listGods.length; i++){
                if (listGods[i] != null){
                    System.out.println("                                  "+ listGods[i]);
                }
            }
            System.out.println();
        }else {
            System.out.println("В сумке нет места для новой покупки");
        }
    }
}
