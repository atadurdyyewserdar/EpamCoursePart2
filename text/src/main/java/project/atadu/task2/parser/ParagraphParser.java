package project.atadu.task2.parser;

import project.atadu.task2.composite.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

    void test() {
        String text = "\tserdar atadurdyyew.\n\tAllanur Wellekow";
        Pattern patter = Pattern.compile(PARAGRAPH_PATTERN);
        Matcher matcher = patter.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public Component parse(String str) {
        return null;
    }

    public static void main(String[] args) {
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.test();
    }
}
