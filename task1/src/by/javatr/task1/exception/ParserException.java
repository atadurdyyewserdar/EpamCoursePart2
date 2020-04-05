package by.javatr.task1.exception;

public class ParserException extends Exception {
    public ParserException() {
        super();
    }

    public ParserException(String msg) {
        super(msg);
    }

    public ParserException(Exception e) {
        super(e);
    }

    public ParserException(String msg, Exception e) {
        super(msg, e);
    }
}
