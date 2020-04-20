package by.javatr.atadu.task1.logic;

import by.javatr.atadu.task1.entity.Point;
import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.generator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuadrangleCalculatorTest {
    Quadrangle quadrangle;
    IdGenerator idGenerator = new IdGenerator();
    QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();

    @BeforeMethod
    public void setUp() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);
        Point c = new Point(3, 3);
        Point d = new Point(3, 1);
        long id = idGenerator.generateId();
        quadrangle = new Quadrangle(id, a, b, c, d);
    }

    @Test
    public void distanceOfTwoPoints() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 3);
        double actual = quadrangleCalculator.distanceOfTwoPoints(a, b);
        double expected = 2;
        Assert.assertEquals(actual, expected, 0.000_001);
    }

    @Test
    public void perimeterTest() {
        double expected = 8;
        double actual = quadrangleCalculator.perimeter(quadrangle);
        Assert.assertEquals(expected, actual, 0.000_001);
    }

    @Test
    public void areaTest() {
        double expected = 4;
        double actual = quadrangleCalculator.area(quadrangle);
        Assert.assertEquals(expected, actual, 0.000_001);
    }

    @Test
    public void isSquareTest() {
        long id = idGenerator.generateId();
        Quadrangle quadrangle = new Quadrangle(id, new Point(1, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(3, 1));
        boolean actual = quadrangleCalculator.isSquare(quadrangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isTrapezoidTest() {
        long id = idGenerator.generateId();
        Quadrangle quadrangle = new Quadrangle(id, new Point(2, 1),
                new Point(1, 4),
                new Point(4, 4),
                new Point(5, 1));
        boolean actual = quadrangleCalculator.isTrapezoid(quadrangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isRectangleTest() {
        long id = idGenerator.generateId();
        Quadrangle quadrangle = new Quadrangle(id, new Point(1, 1),
                new Point(1, 3),
                new Point(4, 3),
                new Point(4, 1));
        boolean actual = quadrangleCalculator.isRectangle(quadrangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isStraightLineTest() {
        boolean expected = quadrangleCalculator.isStraightLine(new Point(1, 1),
                new Point(1, 2), new Point(1, 3));
        Assert.assertTrue(expected);
    }


}
