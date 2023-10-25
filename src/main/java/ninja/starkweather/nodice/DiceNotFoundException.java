package ninja.starkweather.nodice;

public class DiceNotFoundException extends RuntimeException {

    public DiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
