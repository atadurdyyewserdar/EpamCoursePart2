package by.javatr.atadu.task1.entity;

public class Point {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return new StringBuilder("Point { ")
                .append(" x = ").append(x)
                .append(", y = ").append(y)
                .append(" }")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.getX() && y == point.getY();
    }

    @Override
    public int hashCode() {
        return (int) ((x * 31) + (y * 31));
    }
}
