package by.java.atadu.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> child;
    private Type type;

    public Composite() {
    }

    public Composite(Type type) {
        child = new ArrayList<>();
        this.type = type;
    }

    @Override
    public void add(Component component) {
        child.add(component);
    }

    @Override
    public void remove(Component component) {
        child.remove(component);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public CharacterType getPunctuation() {
        return CharacterType.UNKNOWN;
    }

    @Override
    public List<Component> getChild() {
        return child;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : child) {
            switch (type) {
                case PARAGRAPH:
                    stringBuilder.append(component.toString()).append("\n");
                    break;
                case WORD:
                    if (!component.toString().endsWith(".")) {
                        stringBuilder.append(component.toString()).append(" ");
                    } else {
                        stringBuilder.append(component.toString());
                    }
                    break;
                case SENTENCE:
                    stringBuilder.append(component.toString()).append(" ");
                    break;
                default:
                    stringBuilder.append(component.toString());
                    break;
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return child.equals(composite.child) &&
                type == composite.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (Component component : child) {
            result += component.hashCode() * prime;
        }
        result += type.hashCode() * prime;
        return result;
    }
}
