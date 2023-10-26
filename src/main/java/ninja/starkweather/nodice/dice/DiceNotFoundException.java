package ninja.starkweather.nodice.dice;

public class DiceNotFoundException extends RuntimeException {

    public DiceNotFoundException() {
        super();
    }

    public DiceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DiceNotFoundException(final String message) {
        super(message);
    }

    public DiceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
