package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.*;

public class SymbolParser implements Parser {
    @Override
    public Component parse(String str) {
        Component characterComponent = new Composite(Type.CHARACTER);
        if (str.endsWith("...")) {
            for (int i = 0; i < str.length() - 3; i++) {
                director(str.charAt(i), characterComponent);
            }
            characterComponent.add(new Leaf('\u2026', CharacterType.ELLIPSIS));
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
                component.add(new Leaf(c, CharacterType.COLON));
                break;
            case '.':
                component.add(new Leaf(c, CharacterType.PERIOD));
                break;
            case ',':
                component.add(new Leaf(c, CharacterType.COMMA));
                break;
            case ';':
                component.add(new Leaf(c, CharacterType.SEMICOLON));
                break;
            case '?':
                component.add(new Leaf(c, CharacterType.QUESTION_MARK));
                break;
            case '"':
                component.add(new Leaf(c, CharacterType.QUOTATION));
                break;
            case '\'':
                component.add(new Leaf(c, CharacterType.APOSTROPHE));
                break;
            case '!':
                component.add(new Leaf(c, CharacterType.EXCLAMATION));
                break;
            default:
                if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                    component.add(new Leaf(c, CharacterType.LETTER));
                } else if (c >= '0' && c <= '9') {
                    component.add(new Leaf(c, CharacterType.NUMBER));
                } else {
                    component.add(new Leaf(c, CharacterType.UNKNOWN));
                }
                break;
        }
    }
}
