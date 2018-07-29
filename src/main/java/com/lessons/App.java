package src.main.java.com.lessons;
public class App {
    public static void main(String[] args) throws NoSuchMethodException {
//        Finobachi finobachi = new Finobachi();
//        finobachi.countFin(50);
        IFinobachi iFinobachi = ProxyFactory.getInstance(new Finobachi());

        iFinobachi.countFin(2);


    }
}
