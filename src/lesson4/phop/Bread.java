package lesson4.phop;

/*Этот класс является моделью хлеба, которая описывает параметры и методы хлеба.*/

public class Bread implements Item {

   private String name;
   private double price;

   Bread(String name, double price){
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
