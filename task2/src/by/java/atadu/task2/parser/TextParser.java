package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser {
    private static final String REGEX = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";
    private ParagraphParser paragraphParser = new ParagraphParser();
    private Pattern pattern = Pattern.compile(REGEX);

    public Component parse(String str) {
        Matcher matcher = pattern.matcher(str);
        Component paragraphs = new Composite(Lexeme.TEXT);
        while (matcher.find()) {
            Component current = paragraphParser.parse(matcher.group());
            paragraphs.add(current);
        }
        return paragraphs;
    }
}
