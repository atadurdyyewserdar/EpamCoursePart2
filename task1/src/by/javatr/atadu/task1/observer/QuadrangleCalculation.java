package by.javatr.atadu.task1.observer;

public class QuadrangleCalculation {
    private double area;
    private double perimeter;
    private String type;

    public QuadrangleCalculation(double area, double perimeter, String type) {
        this.area = area;
        this.perimeter = perimeter;
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String getType() {
        return type;
    }
}
