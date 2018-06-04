package lesson4.phop;

/*Этот класс является моделью воды, которая описывает параметры и методы воды.*/

public class Water implements Item {

    private String name;
    private double price;

    Water(String name, double price){
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
