package ninja.starkweather.nodice.roll;

public class RollIdMismatchException extends RuntimeException {

    public RollIdMismatchException() {
        super();
    }

    public RollIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RollIdMismatchException(final String message) {
        super(message);
    }

    public RollIdMismatchException(final Throwable cause) {
        super(cause);
    }
    
}
