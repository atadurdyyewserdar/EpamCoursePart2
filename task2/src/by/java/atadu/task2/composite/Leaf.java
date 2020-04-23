package by.java.atadu.task2.composite;

import java.util.Collections;
import java.util.List;

public class Leaf implements Component {
    private Character value;
    private CharacterType type;

    public Leaf(Character value, CharacterType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void add(Component component) {
        //Not supported
    }

    @Override
    public void remove(Component component) {
        //Not supported
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public CharacterType getPunctuation() {
        return type;
    }

    @Override
    public List<Component> getChild() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return value.toString();
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
}
