package by.javatr.entity;

public abstract class Shape {
    private String name;

    public Shape() {
        name = "unknown";
    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shape{ " + name + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return name.equals(shape.getName());
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : 31 * name.hashCode();
    }

    public abstract double area();

    public abstract double perimeter();
}
