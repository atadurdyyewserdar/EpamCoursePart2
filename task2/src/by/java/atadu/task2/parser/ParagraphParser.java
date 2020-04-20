package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

    public Component parse(String str) {
        Pattern pattern = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher matcher = pattern.matcher(str);
        SentenceParser sentenceParser = new SentenceParser();
        Component component = new Composite(Type.PARAGRAPH);
        while (matcher.find()) {
            Component current = sentenceParser.parse(matcher.group());
            component.add(current);
        }
        return component;
    }
}
