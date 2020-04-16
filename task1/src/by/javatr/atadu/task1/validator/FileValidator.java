package by.javatr.atadu.task1.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileValidator {
    private final static Logger logger = LogManager.getLogger();

    public boolean isEmpty(String path) {
        boolean result = false;
        try {
            result = Files.size(Paths.get(path)) == 0;
        } catch (IOException e) {
            logger.error(e);
        }
        return result;
    }
}
