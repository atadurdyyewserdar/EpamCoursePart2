package by.java.atadu.parser;

import by.java.atadu.composite.Component;
import by.java.atadu.composite.Composite;
import by.java.atadu.composite.Type;

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
