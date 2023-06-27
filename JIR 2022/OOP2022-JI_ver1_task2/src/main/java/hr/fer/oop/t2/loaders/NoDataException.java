package hr.fer.oop.t2.loaders;

public class NoDataException extends Exception {
    public NoDataException() {
    }

    public NoDataException(String message) {
        super(message);
    }

    public NoDataException(Exception cause) {
        super(cause);
    }
}
