package by.javatr.atadu.task1.reader;

import by.javatr.atadu.task1.reader.impl.FileReaderShapeImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileReaderShapeTest {
    private FileReaderShapeImpl readerShape = new FileReaderShapeImpl();
    private List<String> expected = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        expected.add("0 0 0 1 1 0 3 3");
        expected.add("0 0 0 2 2 0 3 3");
        expected.add("1 1 1 2 3 3 3 3");
        expected.add("0 0 1 1 4 4 3 3");
        expected.add("08 28 8 8 8 3 3");
        expected.add("8ad 2 2 4 5 3 3");
        expected.add("1 1 0 0 0 0 3 3");
    }

    @Test
    public void readAllTest() throws Exception {
        List<String> fileContent = readerShape.readAll("src/resources/shapes.txt");
        Assert.assertEquals(fileContent, expected);
    }
}
