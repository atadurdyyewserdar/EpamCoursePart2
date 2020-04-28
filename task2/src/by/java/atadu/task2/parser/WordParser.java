package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Type;

public class WordParser implements Parser {
    private static final String REGEX_WORD = "\\s+";
    private SymbolParser symbolParser = new SymbolParser();

    @Override
    public Component parse(String str) {
        Component words = new Composite(Type.WORD);
        String[] data = str.split(REGEX_WORD);
        for (String s : data) {
            Component word = symbolParser.parse(s);
            words.add(word);
        }
        return words;
    }
}
