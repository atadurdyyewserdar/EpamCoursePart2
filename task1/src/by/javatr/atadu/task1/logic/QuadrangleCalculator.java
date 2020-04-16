package by.javatr.atadu.task1.logic;

import by.javatr.atadu.task1.entity.Point;
import by.javatr.atadu.task1.entity.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleCalculator {
    private static Logger logger = LogManager.getLogger();

    public double perimeter(Quadrangle quadrangle) {
        double sideAD = distanceOfTwoPoints(quadrangle.getD(), quadrangle.getA());
        double sideAB = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
        double sideBC = distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
        double sideCD = distanceOfTwoPoints(quadrangle.getC(), quadrangle.getD());
        double result = sideAB + sideAD + sideBC + sideCD;
        System.out.println(sideAB);
        System.out.println(sideAD);
        System.out.println(sideBC);
        System.out.println(sideCD);
        logger.info("Calculated Quadrangle Id: " + quadrangle.getId() + "\tperimeter: " + result);
        return result;
    }

    public double area(Quadrangle quadrangle) {
        double ab = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
        double bc = distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
        double ac = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getC());
        double ad = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getD());
        double cd = distanceOfTwoPoints(quadrangle.getC(), quadrangle.getD());
        double pp1 = (ab + bc + ac) / 2;
        double pp2 = (ac + cd + ad) / 2;
         double result = Math.sqrt(pp1 * (pp1 - ab) * (pp1 - bc) * (pp1 - ac)) + Math.sqrt(pp2 * (pp2 - ac) * (pp2 - cd) * (pp2 - ad));
        logger.info("Calculated area for quadrangle Id: " + quadrangle.getId() + "\tarea: " + result);
        return result;
    }

    public String quadrangleType(Quadrangle quadrangle) {
        String result = "undefined";
        if (isSquare(quadrangle)) {
            result = "Square";
        } else if (isRectangle(quadrangle)) {
            result = "Rectangle";
        } else if (isParallelogram(quadrangle)) {
            result = "Parallelogram";
        }
        logger.info("Calculated type for quadrangle Id: " + quadrangle.getId() + "\ttype: " + result);
        return result;
    }

    public boolean isParallelogram(Quadrangle quadrangle) {
        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();
        double AB = b.getY() - a.getY() / b.getX() - a.getX();
        double CD = c.getY() - d.getY() / c.getX() - d.getX();
        double AD = d.getY() - a.getY() / d.getX() - a.getX();
        double BC = c.getY() - b.getY() / c.getX() - b.getX();
        return AB == CD && AD == BC;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        double sideAB = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
        double sideBC = distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
        double sideCD = distanceOfTwoPoints(quadrangle.getC(), quadrangle.getD());
        double sideAD = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getD());
        return sideAB == sideAD
                && sideAB == sideBC
                && sideAB == sideCD;
    }

    public boolean isRectangle(Quadrangle quadrangle) {
        double ab = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
        double bc = distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
        double cd = distanceOfTwoPoints(quadrangle.getC(), quadrangle.getD());
        double ad = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getD());
        double ac = distanceOfTwoPoints(quadrangle.getA(), quadrangle.getC());
        double bd = distanceOfTwoPoints(quadrangle.getB(), quadrangle.getD());
        return ac == bd
                && ab == cd
                && bc == ad
                && ab != bc;
    }

    public boolean isTrapezoid(Quadrangle q) {
        double bc = slope(q.getB(), q.getC());
        double ad = slope(q.getA(), q.getD());
        double ab = slope(q.getB(), q.getC());
        double dc = slope(q.getB(), q.getA());
        return bc == ad || ab == dc;
    }

    public double distanceOfTwoPoints(Point p, Point q) {
        return Math.sqrt(Math.pow(q.getX() - p.getX(), 2) + Math.pow(q.getY() - p.getY(), 2));
    }

    public boolean isStraightLine(Point a, Point b, Point c) {
        return slope(a, b) == slope(b, c)
                && slope(b, c) == slope(a, c);
    }

    private double slope(Point a, Point b) {
        return (a.getY() - b.getY()) / (a.getX() - b.getX());
    }
}
