package main.by.javatr.task1.reader.impl;

import main.by.javatr.task1.reader.FileReaderShape;
import main.by.javatr.task1.reader.exception.ReaderException;
import main.by.javatr.task1.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderShapeImpl implements FileReaderShape {
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readAll(String path) throws ReaderException {
        if (path == null) {
            logger.error("Path wasn't found");
            throw new ReaderException("Path is null");
        }
        FileValidator fileValidator = new FileValidator();
        if (fileValidator.isExist(path) || fileValidator.isEmpty(path)) {
            logger.fatal("Error reading file");
            throw new ReaderException("Error reading file");
        }
        List<String> lines = new ArrayList<>();
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            lines = fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.fatal(e);
        }
        return lines;
    }
}
