package main.by.javatr.task1.reader;

import main.by.javatr.task1.reader.exception.ReaderException;

import java.util.List;

public interface FileReaderShape {
    List<String> readAll(String path) throws ReaderException;
}
