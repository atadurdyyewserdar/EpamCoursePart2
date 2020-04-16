package by.javatr.atadu.task1.reader;

import by.javatr.atadu.task1.exception.ReaderException;

import java.util.List;

public interface FileReaderShape {
    List<String> readAll(String path) throws ReaderException;
}
