package main.task1.entity;

public class Quadrangle {
    private long id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrangle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) o;
        return a.equals(quadrangle.getA())
                && b.equals(quadrangle.getB())
                && c.equals(quadrangle.getC())
                && d.equals(quadrangle.getD());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result += prime * id
                + prime * a.hashCode()
                + prime * b.hashCode()
                + prime * c.hashCode()
                + prime * d.hashCode();
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
