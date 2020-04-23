package by.java.atadu.task2.reader.impl;

import by.java.atadu.task2.reader.TextReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
    public static final String DEFAULT_PATH = "src/resources/text.txt";

    TextReaderImpl() {
    }

    @Override
    public String read(String path) {
        String line = null;
        try {
            line = Files.readString(Path.of(path));
        } catch (IOException e) {
            //Exception
        }
        return line;
    }
}
