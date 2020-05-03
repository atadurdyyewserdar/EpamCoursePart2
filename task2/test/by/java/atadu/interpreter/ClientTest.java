package by.java.atadu.interpreter;

import org.testng.annotations.Test;

public class ClientTest {
    @Test
    public void calculateTest() {
        String expression = "8 2 7 4 + * -";
        Client interpreter = new Client();
        interpreter.parse(expression);
        System.out.println("[ " + expression + " ] = " + interpreter.calculate());
    }
}
