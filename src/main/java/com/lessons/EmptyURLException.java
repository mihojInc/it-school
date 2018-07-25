package src.main.java.com.lessons;

public class EmptyURLException extends Exception {
    public EmptyURLException() {
        super();
    }

    public EmptyURLException(String message) {
        super(message);
    }
}
