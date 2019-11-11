package music;

public class MusicException extends RuntimeException {
    public MusicException() {
        super();
    }

    public MusicException(final String message) {
        super(message);
    }

    public MusicException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MusicException(final Throwable cause) {
        super(cause);
    }

    protected MusicException(final String message, final Throwable cause,
                             final boolean enableSuppression,
                             final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
