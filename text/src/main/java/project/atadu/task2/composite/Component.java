package project.atadu.task2.composite;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    String getValue();

    List<Component> getChildren();
}
