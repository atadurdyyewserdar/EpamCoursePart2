package by.java.atadu.task2.composite;

import java.util.List;

public class Leaf implements Component {
    private String value;
    private Type type;

    public Leaf(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return value.equals(leaf.value) &&
                type == leaf.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result += prime * value.hashCode() + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Leaf{value=")
                .append(value)
                .append(", type=")
                .append(type)
                .append('}').toString();
    }
}
