package by.javatr.task1.entity;

public abstract class Shape {
    protected long id;

    public Shape(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shape{ id = " + id + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return id == shape.getId();
    }

    @Override
    public int hashCode() {
        return (int) (31 * id);
    }

    public abstract double area();

    public abstract double perimeter();
}
