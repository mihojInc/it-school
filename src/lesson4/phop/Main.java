package lesson4.phop;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop(3, 15.0);

        Bread bread = new Bread("Хлеб", 12.0);
        Salo salo = new Salo("Копченое сало");
        Water water = new Water("Березовская", 3.0);


        shop.buyGood(salo);
        shop.buyGood(water);
        shop.sellGood(bread);
    }


}