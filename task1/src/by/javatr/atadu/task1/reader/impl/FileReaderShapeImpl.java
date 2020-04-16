package by.javatr.atadu.task1.reader.impl;

import by.javatr.atadu.task1.reader.FileReaderShape;
import by.javatr.atadu.task1.exception.ReaderException;
import by.javatr.atadu.task1.validator.FileValidator;
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
            logger.fatal("Path wasn't found");
            throw new ReaderException("Path is null");
        }
        FileValidator fileValidator = new FileValidator();
        if (fileValidator.isEmpty(path)) {
            logger.error("Empty file");
            throw new ReaderException("Empty file");
        }
        List<String> lines = new ArrayList<>();
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            lines = fileStream.collect(Collectors.toList());
            logger.info("Read from file" + lines.size() + " lines");
        } catch (IOException e) {
            logger.error(e);
        }
        return lines;
    }
}
