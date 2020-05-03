package by.java.atadu.composite;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    Type getType();

    CharacterType getPunctuation();

    List<Component> getChild();
}
