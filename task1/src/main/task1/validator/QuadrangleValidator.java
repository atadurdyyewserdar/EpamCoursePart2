package main.task1.validator;

import main.task1.entity.Point;
import main.task1.entity.Quadrangle;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrangleValidator {
    final static String REGEX = "\\s*(\\d+.?\\d+\\s+){3}\\d+.?\\d+\\s*+";

    public QuadrangleValidator() {
    }

    public boolean validate(String line) {
        if (line == null) {
            //TODO: exception or return false << ? >>
            //TODO: Logger
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public boolean validate(List<String> lines) {
        if (lines == null) {
            //TODO: exception or return false << ? >>
            //TODO: Logger
        }
        boolean result = true;
        for (String line : lines) {
            if (!validate(line)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public boolean isCorrectQuadrangle(Quadrangle quadrangle) {
        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();
        double ad = distance(a.getX(), a.getY(), d.getX(), d.getY());
        double ab = distance(a.getX(), a.getY(), b.getX(), b.getY());
        double bc = distance(b.getX(), b.getY(), c.getX(), c.getY());
        double cd = distance(c.getX(), c.getY(), d.getX(), d.getY());
        return ad < ab + bc + cd
                && ab < ad + bc + cd
                && bc < ad + ab + cd
                && cd < ad + bc + cd;
    }
}
