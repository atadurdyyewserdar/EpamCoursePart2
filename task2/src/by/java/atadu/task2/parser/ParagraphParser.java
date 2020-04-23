package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private static final String REGEX_SENTENCE = "^\\s+[A-Za-z,;'\"\\s]+[.?!]$";
    private SentenceParser sentenceParser = new SentenceParser();
    private Pattern pattern = Pattern.compile(REGEX_SENTENCE);

    public Component parse(String str) {
        Matcher matcher = pattern.matcher(str);
        Component sentences = new Composite(Type.PARAGRAPH);
        while (matcher.find()) {
            Component sentence = sentenceParser.parse(matcher.group());
            sentences.add(sentence);
        }
        return sentences;
    }
}
