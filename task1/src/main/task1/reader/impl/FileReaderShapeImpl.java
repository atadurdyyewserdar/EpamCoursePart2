package main.task1.reader.impl;

import main.task1.exception.FileReaderException;
import main.task1.reader.FileReaderShape;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderShapeImpl implements FileReaderShape {
    private final String DEFAULT_PATH = "resources/shapes.txt";

    @Override
    public List<String> readAll(String path) throws FileReaderException {
        List<String> lines = new ArrayList<>();
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            lines = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            //TODO Logger
            e.printStackTrace();
        }
        return lines;
    }
}
