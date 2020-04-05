package by.javatr.task1.entity;

public class Quadrangle extends Shape {
    private double a;
    private double b;
    private double c;
    private double d;

    public Quadrangle(long id) {
        super(id);
    }

    public Quadrangle(long id, double a, double b, double c, double d) {
        super(id);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
