package by.javatr.task1.entity;

public class Quadrangle {
    private long id;
    private double a;
    private double b;
    private double c;
    private double d;

    public Quadrangle() {
    }

    public Quadrangle(long id, double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) o;
        return id == quadrangle.getId()
                && a == quadrangle.getA()
                && b == quadrangle.getB()
                && c == quadrangle.getC()
                && d == quadrangle.getD();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result += prime * id + prime * a + prime * b + prime * c + prime * d;
        return result;
    }

    @Override
    public String toString() {
        return "Quadrangle {"
                + "id = " + id
                + "a = " + a
                + "b = " + b
                + "c = " + c
                + "d = " + d
                + "}";
    }
}
