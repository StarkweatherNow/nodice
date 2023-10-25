package ninja.starkweather.nodice;

public class DiceIDMismatchException extends RuntimeException {

    public DiceIDMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
