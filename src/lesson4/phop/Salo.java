package lesson4.phop;


/*Этот класс является моделью Сала, которая описывает параметры и методы сала.*/

public class Salo implements Item {

    private String name;
    private static final double price = 3d ;

    Salo(String name ){
        this.name =name;
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
