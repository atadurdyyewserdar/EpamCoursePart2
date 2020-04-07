package main.task1.exception;

public class FileReaderException extends Exception {
    public FileReaderException() {
        super();
    }

    public FileReaderException(String msg) {
        super(msg);
    }

    public FileReaderException(Exception e) {
        super(e);
    }

    public FileReaderException(String msg, Exception e) {
        super(msg, e);
    }
}
