package by.java.atadu.task2.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<Expression> expressions = new ArrayList<>();

    public void parse(String string) {
        String regex = "\\s+";
        for (String lexeme : string.split(regex)) {
            char t = lexeme.charAt(0);
            switch (t) {
                case '+':
                    expressions.add(context -> context.push(context.pop() + context.pop()));
                    break;
                case '-':
                    expressions.add(context -> context.push(context.pop() - context.pop()));
                    break;
                case '*':
                    expressions.add(context -> context.push(context.pop() * context.pop()));
                    break;
                case '/':
                    expressions.add(context -> context.push(context.pop() / context.pop()));
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        expressions.add(c -> c.push(scanner.nextInt()));
                    }
                    break;

            }
        }
    }

    public Integer calculate() {
        Context context = new Context();
        expressions.forEach(expression -> expression.interpret(context));
        return context.pop();
    }

}
