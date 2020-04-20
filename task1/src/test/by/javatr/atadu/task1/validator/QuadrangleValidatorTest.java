package by.javatr.atadu.task1.validator;

import by.javatr.atadu.task1.entity.Point;
import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.generator.IdGenerator;
import by.javatr.atadu.task1.logic.QuadrangleCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuadrangleValidatorTest {
    IdGenerator idGenerator = new IdGenerator();
    QuadrangleValidator quadrangleValidator = new QuadrangleValidator();

    @Test
    public void isCorrectQuadrangleTest() {
        Point a = new Point(1, 3);
        Point b = new Point(1, 3);
        Point c = new Point(1, 3);
        Point d = new Point(3, 1);
        long id = idGenerator.generateId();
        boolean actual = quadrangleValidator.isCorrectQuadrangle(a, b, c, d);
        System.out.println(actual);
        Assert.assertTrue(actual);
    }

    @Test
    public void validateTest() {
        String line = "1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0";
        boolean actual = quadrangleValidator.validate(line);
        Assert.assertTrue(actual);
    }

}
