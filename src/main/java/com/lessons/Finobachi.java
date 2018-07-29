package src.main.java.com.lessons;

@Description(before = "Start count", after = "End operation")
public class Finobachi implements IFinobachi {

    @Override
    @For(num = 5)
    public void countFin(int num) {
        // algorithm
        int a = 1, b = 1;
        while (a <= num){
            System.out.print(a + " ");
            b = b + a;
            a = b - a;
        }
        System.out.println();
    }
}
