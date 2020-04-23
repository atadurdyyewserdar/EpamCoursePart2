package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.*;

public class WordParser implements Parser {
    @Override
    public Component parse(String str) {
        Component characterComponent = new Composite(Lexeme.WORD);
        if (str.endsWith("...")) {
            for (int i = 0; i < str.length() - 3; i++) {
                director(str.charAt(i), characterComponent);
            }
            characterComponent.add(new Leaf('\u2026', PunctuationMark.ELLIPSIS));
        } else {
            for (char c : str.toCharArray()) {
                director(c, characterComponent);
            }
        }
        return characterComponent;
    }

    private void director(Character c, Component component) {
        switch (c) {
            case ':':
                component.add(new Leaf(c, PunctuationMark.COLON));
                break;
            case '.':
                component.add(new Leaf(c, PunctuationMark.PERIOD));
                break;
            case ',':
                component.add(new Leaf(c, PunctuationMark.COMMA));
                break;
            case ';':
                component.add(new Leaf(c, PunctuationMark.SEMICOLON));
                break;
            case '?':
                component.add(new Leaf(c, PunctuationMark.QUESTION_MARK));
                break;
            case '"':
                component.add(new Leaf(c, PunctuationMark.QUOTATION));
                break;
            case '\'':
                component.add(new Leaf(c, PunctuationMark.APOSTROPHE));
                break;
            case '!':
                component.add(new Leaf(c, PunctuationMark.EXCLAMATION));
                break;
            default:
                if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                    component.add(new Leaf(c, PunctuationMark.LETTER));
                } else if (c >= '0' && c <= '9') {
                    component.add(new Leaf(c, PunctuationMark.NUMBER));
                } else {
                    component.add(new Leaf(c, PunctuationMark.UNKNOWN));
                }
                break;
        }
    }
}
