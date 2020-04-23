package by.java.atadu.task2.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> child;
    private Lexeme type;

    public Composite(Lexeme type) {
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
    public Lexeme getLexemeType() {
        return type;
    }

    @Override
    public PunctuationMark getPunctuation() {
        return PunctuationMark.UNKNOWN;
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
                case SENTENCE:
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
