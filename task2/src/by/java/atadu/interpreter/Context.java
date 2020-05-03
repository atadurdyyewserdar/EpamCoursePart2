package by.java.atadu.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    public Integer pop() {
        return arrayDeque.pop();
    }

    public void push(Integer i) {
        arrayDeque.push(i);
    }
}
