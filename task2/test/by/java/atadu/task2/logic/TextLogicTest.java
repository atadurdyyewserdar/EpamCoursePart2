package by.java.atadu.task2.logic;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;
import by.java.atadu.task2.parser.ParagraphParser;
import by.java.atadu.task2.reader.TextReader;
import by.java.atadu.task2.reader.impl.TextReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class TextLogicTest {
    private String text;
    private TextLogic textLogic;
    private Component component;

    @BeforeMethod
    public void setUp() {
        //1 -> 33
        //2 -> 17
        //3 -> 36
        //4 -> 24
        text = new StringBuilder()
                .append("\tFor writers, a random sentence can help them get their creative juices flowing. Since the topic of the sentence is completely unknown, it forces the writer to be creative when the sentence appears.\n")
                .append("\tThere are a number of different ways a writer can use the random thisIsALongestWord sentence for creativity.\n")
                .append("\tThe most common way to use the sentence is to begin a story. Another option is to include it somewhere in the story. A much more difficult challenge is to use it to end a story.\n")
                .append("\tIn any of these cases, it forces the writer to think creatively since they have no idea what sentence will appear from the tool.\n")
                .toString();
        textLogic = new TextLogic();
        ParagraphParser paragraphParser = new ParagraphParser();
        component = paragraphParser.parse(text);
    }

    @Test
    public void sortParagraphBySentenceCount() {
        textLogic.sortParagraphBySentenceCount(component);
    }

    @Test
    public void findLongestWordTest() {
        String actual = textLogic.findLongestWord(component);
        String expected = "There are a number of different ways a writer can use the random thisIsALongestWord sentence for creativity.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deleteSentenceTest() {
    }

    @Test
    public void findSimilarWordTest() {
        int actual = 5;
        String text = "\tOne two three. Four five six seven.\n\tEight nine ten one two.\n";
        TextLogic textLogic2 = new TextLogic();
        ParagraphParser paragraphParser2 = new ParagraphParser();
        Component component2 = paragraphParser2.parse(text);
        int count = textLogic.countSimilarWords(component2);
        System.out.println(count);
    }
}
