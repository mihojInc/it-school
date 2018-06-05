package lesson4.phop;

/*Этот класс продукт, который описывает параметры и методы продукта.*/

public class Product implements Item {

    private String name;
    private double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }


}
