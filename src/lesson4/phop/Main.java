package lesson4.phop;

public class Main {
 /* создаем объекты, и вводим их параметры*/

    public static void main(String[] args) {
        Shop shop = new Shop(6, 30.0 );
        Buyer buyer = new Buyer(4,50.0, 1.25);


        Bread bread = new Bread("Хлеб ", 12.0);
        Salo salo = new Salo("Сало ");
        Water water = new Water("Минералка ", 3.0);

        Product product =new Product("  ", 0);

        shop.buyGood(salo);
        shop.buyGood(water);
        shop.buyGood(bread);
        shop.buyProduct(product);

        buyer.sellGood(water);
        buyer.sellGood(salo);

        //shop.sellGood(bread);

    }


}