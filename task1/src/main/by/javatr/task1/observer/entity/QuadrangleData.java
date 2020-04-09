package main.by.javatr.task1.observer.entity;

public class QuadrangleData {
    private double perimeter;
    private double area;
    private String type;

    public QuadrangleData(double perimeter, double area, String type) {
        this.perimeter = perimeter;
        this.area = area;
        this.type = type;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
