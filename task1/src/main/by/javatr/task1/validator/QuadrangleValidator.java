package main.by.javatr.task1.validator;

import main.by.javatr.task1.entity.Point;
import main.by.javatr.task1.entity.Quadrangle;
import main.by.javatr.task1.logic.PointLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrangleValidator {
    final static String REGEX = "([\\s+]*[-+]?[\\d+]*\\.?[\\d]+([eE][-+]?[\\d]+)?[\\s+]*){8}";

    public QuadrangleValidator() {
    }

    public boolean validate(String line) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public boolean isCorrectQuadrangle(Point A, Point B, Point C, Point D) {
        return isOnLine(B, C, D)
                || isOnLine(A, C, D)
                || isOnLine(A, B, D)
                || isOnLine(A, B, C);
    }

    private boolean isOnLine(Point a, Point b, Point c) {
        return (c.getX() - a.getX() / b.getX() - a.getX())
                == (c.getY() - a.getY() / b.getY() - a.getY());
    }

}
