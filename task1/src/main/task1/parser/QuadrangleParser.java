package main.task1.parser;

import main.task1.entity.Quadrangle;
import main.task1.exception.FileReaderException;
import main.task1.exception.ParserException;
import main.task1.reader.impl.FileReaderShapeImpl;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleParser {
    public List<Quadrangle> parse() throws ParserException {
        List<Quadrangle> quadrangles = new ArrayList<>();
        FileReaderShapeImpl fileReaderShape = new FileReaderShapeImpl();
        try {
            List<String> lines = fileReaderShape.readAll("resources/shapes.txt");
        } catch (FileReaderException e) {
            //TODO Logger
            throw new ParserException(e);
        }
        return null;
    }
}
