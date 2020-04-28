package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private static final String REGEX_PARAGRAPH = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";
    private SentenceParser sentenceParser = new SentenceParser();

    public Component parse(String str) {
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(str);
        Component paragraphs = new Composite(Type.PARAGRAPH);
        while (matcher.find()) {
            Component current = sentenceParser.parse(matcher.group());
            paragraphs.add(current);
        }
        return paragraphs;
    }
}
