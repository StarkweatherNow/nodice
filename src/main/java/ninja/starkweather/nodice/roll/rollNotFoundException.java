package ninja.starkweather.nodice.roll;

public class RollNotFoundException extends RuntimeException {

    public RollNotFoundException() {
        super();
    }

    public RollNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RollNotFoundException(final String message) {
        super(message);
    }

    public RollNotFoundException(final Throwable cause) {
        super(cause);
    }

}
