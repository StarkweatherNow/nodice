package ninja.starkweather.nodice.dice;

public class DiceNotFoundException extends RuntimeException {

    public DiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
