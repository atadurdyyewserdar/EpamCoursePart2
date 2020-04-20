package by.java.atadu.task2.parser;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.composite.Leaf;
import by.java.atadu.task2.composite.Type;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private String sentence;
    private Component expected;

    @BeforeMethod
    public void setUp() {
        sentence = "Hello, my name is Serdar.";
        expected = new Composite(Type.SENTENCE);
        expected.add(new Leaf("Hello,", Type.WORD));
        expected.add(new Leaf("my", Type.WORD));
        expected.add(new Leaf("name", Type.WORD));
        expected.add(new Leaf("is", Type.WORD));
        expected.add(new Leaf("Serdar.", Type.WORD));
    }

    @Test
    public void parseTest() {
        Parser parser = new SentenceParser();
        Component actual = parser.parse(sentence);
        Assert.assertEquals(actual, expected);
    }
}
