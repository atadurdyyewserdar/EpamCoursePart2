package project.atadu.task2.parser;

import project.atadu.task2.composite.Component;

public class SentenceParser implements Parser {
    private static final String WORD_PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";
    private static final String EXPRESSION_PATTERN = "[\\d]+[ \\d/*+-=]+[\\d/*+-=]+";
    private static final String LEXEME_PATTERN = "(" + WORD_PATTERN + ")|(" + EXPRESSION_PATTERN + ")";

    public Component parse(String str) {
        return null;
    }

    public static void main(String[] args) {

    }
}
