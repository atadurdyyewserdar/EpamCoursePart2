package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Lexeme;

public class SentenceParser implements Parser {
    private static final String REGEX = "\\s+";
    private WordParser wordParser = new WordParser();

    @Override
    public Component parse(String str) {
        Component words = new Composite(Lexeme.SENTENCE);
        String[] data = str.split(REGEX);
        for (String s : data) {
            Component word = wordParser.parse(s);
            words.add(word);
        }
        return words;
    }
}
