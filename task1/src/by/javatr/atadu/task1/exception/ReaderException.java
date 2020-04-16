package by.javatr.atadu.task1.exception;

public class ReaderException extends Exception {
    public ReaderException() {
    }

    public ReaderException(Exception e) {
        super(e);
    }

    public ReaderException(String msg, Exception e) {
        super(msg, e);
    }

    public ReaderException(String msg) {
        super(msg);
    }
}
