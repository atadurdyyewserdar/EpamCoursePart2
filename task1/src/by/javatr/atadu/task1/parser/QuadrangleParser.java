package by.javatr.atadu.task1.parser;

import by.javatr.atadu.task1.entity.Point;
import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.generator.IdGenerator;
import by.javatr.atadu.task1.exception.ParserException;
import by.javatr.atadu.task1.validator.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleParser {
    private final IdGenerator idGenerator = new IdGenerator();
    private static Logger logger = LogManager.getLogger();

    public Quadrangle parse(String line) throws ParserException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.validate(line)) {
            logger.error("Invalid line for Quadrangle");
            throw new ParserException("Invalid line for Quadrangle");
        }
        String regex = "\\s+";
        String[] points = line.split(regex);
        double aX = Double.parseDouble(points[0]);
        double aY = Double.parseDouble(points[1]);
        double bX = Double.parseDouble(points[2]);
        double bY = Double.parseDouble(points[3]);
        double cX = Double.parseDouble(points[4]);
        double cY = Double.parseDouble(points[5]);
        double dX = Double.parseDouble(points[6]);
        double dY = Double.parseDouble(points[7]);
        Point a = new Point(aX, aY);
        Point b = new Point(bX, bY);
        Point c = new Point(cX, cY);
        Point d = new Point(dX, dY);
        if (!quadrangleValidator.isCorrectQuadrangle(a, b, c, d)) {
            logger.error("Wrong Quadrangle data");
            throw new ParserException("Wrong Quadrangle data");
        }
        long id = idGenerator.generateId();
        return new Quadrangle(id, a, b, c, d);
    }
}
