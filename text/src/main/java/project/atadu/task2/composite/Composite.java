package project.atadu.task2.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components;

    public Composite() {
        components = new ArrayList<Component>();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.getValue());
        }
        return stringBuilder.toString();
    }

    public List<Component> getChildren() {
        return components;
    }
}
