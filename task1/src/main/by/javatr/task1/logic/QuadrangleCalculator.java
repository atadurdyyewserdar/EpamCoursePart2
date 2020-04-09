package main.by.javatr.task1.logic;

import main.by.javatr.task1.entity.Point;
import main.by.javatr.task1.entity.Quadrangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleCalculator {
    private static Logger logger = LogManager.getLogger();

    public double perimeter(Quadrangle quadrangle) {
        double sideAD = PointLogic.distanceOfTwoPoints(quadrangle.getA(), quadrangle.getD());
        double sideAB = PointLogic.distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
        double sideBC = PointLogic.distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
        double sideCD = PointLogic.distanceOfTwoPoints(quadrangle.getC(), quadrangle.getD());
        double result = sideAB + sideAD + sideBC + sideCD;
        logger.info("Quadrangle Id: " + quadrangle.getId() + "\tperimeter: " + result);
        return result;
    }

    public double area(Quadrangle quadrangle) {
        double result = 0;
        if (isSquare(quadrangle)) {
            double ab = PointLogic.distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
            result = ab * ab;
        } else if (isRectangle(quadrangle)) {
            double ab = PointLogic.distanceOfTwoPoints(quadrangle.getA(), quadrangle.getB());
            double bc = PointLogic.distanceOfTwoPoints(quadrangle.getB(), quadrangle.getC());
            result = ab * bc;
        } else if (isParallelogram(quadrangle)) {
        }
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
        return result;
    }

    private boolean isParallelogram(Quadrangle quadrangle) {
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

    private boolean isSquare(Quadrangle quadrangle) {
        Point p1 = quadrangle.getA();
        Point p2 = quadrangle.getB();
        Point p3 = quadrangle.getC();
        Point p4 = quadrangle.getD();

        int d2 = (int) PointLogic.distanceOfTwoPoints(p1, p2); // from p1 to p2
        int d3 = (int) PointLogic.distanceOfTwoPoints(p1, p3); // from p1 to p3
        int d4 = (int) PointLogic.distanceOfTwoPoints(p1, p4); // from p1 to p4

        boolean result = false;

        if (d2 == 0 || d3 == 0 || d4 == 0) {
            result = false;
        }

        if (d2 == d3 && 2 * d2 == d4
                && 2 * (int) PointLogic.distanceOfTwoPoints(p2, p4)
                == (int) PointLogic.distanceOfTwoPoints(p2, p3)) {
            result = true;
        }

        if (d3 == d4 && 2 * d3 == d2
                && 2 * (int) PointLogic.distanceOfTwoPoints(p3, p2)
                == (int) PointLogic.distanceOfTwoPoints(p3, p4)) {
            result = true;
        }
        if (d2 == d4 && 2 * d2 == d3
                && 2 * (int) PointLogic.distanceOfTwoPoints(p2, p3)
                == (int) PointLogic.distanceOfTwoPoints(p2, p4)) {
            result = true;
        }

        return result;
    }

    private boolean isRectangle(Quadrangle quadrangle) {
        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();
        double ab = PointLogic.distanceOfTwoPoints(a, b);
        double bc = PointLogic.distanceOfTwoPoints(b, c);
        double cd = PointLogic.distanceOfTwoPoints(c, d);
        double ad = PointLogic.distanceOfTwoPoints(a, d);
        boolean result = false;
        if (ab == bc && ab == cd &&
                ab == ad && cd == ad &&
                bc == cd && bc == ad) {
            result = true;
        } else if (ab == bc && cd == ad) {
            result = true;
        } else if (ab == ad && cd == bc) {
            result = true;
        } else if (ab == cd && ad == bc) {
            result = true;
        }
        return false;
    }
}
