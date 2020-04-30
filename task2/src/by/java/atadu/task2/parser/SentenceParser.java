package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private static final String REGEX_SENTENCE = "[ a-zA-Z1-9,;:()*/+-]+([.]{3}|[.?!])";
    private WordParser wordParser = new WordParser();


    public Component parse(String str) {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(str);
        Component sentences = new Composite(Type.SENTENCE);
        while (matcher.find()) {
            Component sentence = wordParser.parse(matcher.group());
            sentences.add(sentence);
        }
        return sentences;
    }
}
