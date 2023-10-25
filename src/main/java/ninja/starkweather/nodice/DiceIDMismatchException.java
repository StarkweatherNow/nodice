package ninja.starkweather.nodice;

public class DiceIdMismatchException extends RuntimeException {

    public DiceIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
