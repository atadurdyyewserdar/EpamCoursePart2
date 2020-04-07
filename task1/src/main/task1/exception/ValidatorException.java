package main.task1.exception;

public class ValidatorException extends Exception {
    public ValidatorException() {
        super();
    }

    public ValidatorException(String msg) {
        super(msg);
    }

    public ValidatorException(Exception e) {
        super(e);
    }

    public ValidatorException(String msg, Exception e) {
        super(msg, e);
    }
}
