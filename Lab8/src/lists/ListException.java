package lists;

public class ListException extends RuntimeException {
    public ListException() {
        super();
    }

    public ListException(final String message) {
        super(message);
    }

    public ListException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ListException(final Throwable cause) {
        super(cause);
    }

    protected ListException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
