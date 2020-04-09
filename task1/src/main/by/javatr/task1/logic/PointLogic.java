package main.by.javatr.task1.logic;

import main.by.javatr.task1.entity.Point;

final public class PointLogic {
    private PointLogic() {
    }

    public static double distanceOfTwoPoints(Point a, Point b) {
        double pow = Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2);
        return Math.sqrt(Math.abs(pow));
    }
}
