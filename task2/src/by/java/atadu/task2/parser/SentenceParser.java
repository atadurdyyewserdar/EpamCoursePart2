package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Leaf;
import by.java.atadu.task2.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private static final String PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";

    public Component parse(String str) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(str);
        Component component = new Composite(Type.SENTENCE);
        while (matcher.find()) {
            Component curr = new Leaf(matcher.group(), Type.WORD);
            component.add(curr);
        }
        return component;
    }
}
