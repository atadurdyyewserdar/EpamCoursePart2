package by.javatr.atadu.task1.exception;

public class ParserException extends Exception {
    public ParserException() {
    }

    public ParserException(Exception e) {
        super(e);
    }

    public ParserException(String msg, Exception e) {
        super(msg, e);
    }

    public ParserException(String msg) {
        super(msg);
    }
}
