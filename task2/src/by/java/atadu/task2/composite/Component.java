package by.java.atadu.task2.composite;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    Type getType();

    CharacterType getPunctuation();

    List<Component> getChild();
}
