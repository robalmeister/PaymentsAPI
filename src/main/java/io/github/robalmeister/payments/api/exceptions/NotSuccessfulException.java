package io.github.robalmeister.payments.api.exceptions;

public class NotSuccessfulException extends RuntimeException{
    private final String body;
    public NotSuccessfulException(String message, String body) {
        super(message);
        this.body = body;
    }

    public NotSuccessfulException(String message, Throwable cause, String body) {
        super(message, cause);
        this.body = body;
    }

    public NotSuccessfulException(Throwable cause, String body) {
        super(cause);
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
