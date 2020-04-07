package main.task1.reader;

import main.task1.exception.FileReaderException;

import java.util.List;

public interface FileReaderShape {
    List<String> readAll(String path) throws FileReaderException;
}
