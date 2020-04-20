package by.java.atadu.task2.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children;
    private Type type;

    public Composite(Type type) {
        children = new ArrayList<Component>();
        this.type = type;
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : children) {
            if (type == Type.SENTENCE) {
                stringBuilder.append(component.getValue()).append(" ");
            } else if (type == Type.PARAGRAPH) {
                stringBuilder.append(component.getValue()).append("\n");
            }

        }
        return stringBuilder.toString();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return children.equals(composite.children) &&
                type == composite.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (Component component : children) {
            result += component.hashCode() * prime;
        }
        result += type.hashCode() * prime;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Composite{children=")
                .append(children)
                .append(", type=")
                .append(type)
                .append('}').toString();
    }
}
