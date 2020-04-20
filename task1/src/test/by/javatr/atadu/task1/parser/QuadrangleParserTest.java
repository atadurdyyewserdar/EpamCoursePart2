package by.javatr.atadu.task1.parser;

import by.javatr.atadu.task1.entity.Point;
import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.exception.ParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadrangleParserTest {
    @Test
    public void parseTest() throws ParserException {
        QuadrangleParser quadrangleParser = new QuadrangleParser();
        Quadrangle actual = quadrangleParser.parse("1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0");
        Quadrangle expected = new Quadrangle(actual.getId(),
                new Point(1, 1), new Point(1, 3),
                new Point(3, 3), new Point(3, 1));
        Assert.assertEquals(actual, expected);
    }
}
