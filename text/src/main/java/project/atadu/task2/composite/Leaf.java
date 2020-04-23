package project.atadu.task2.composite;

import java.util.List;

public class Leaf implements Component {
    String data;

    public Leaf(String data) {
        this.data = data;
    }

    public void add(Component component) {
    }

    public void remove(Component component) {
    }

    public String getValue() {
        return data;
    }

    public List<Component> getChildren() {
        return null;
    }
}
