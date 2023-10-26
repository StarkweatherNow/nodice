package ninja.starkweather.nodice.dice;

public class DiceIdMismatchException extends RuntimeException {

    public DiceIdMismatchException() {
        super();
    }

    public DiceIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DiceIdMismatchException(final String message) {
        super(message);
    }

    public DiceIdMismatchException(final Throwable cause) {
        super(cause);
    }
    
}
