package main.by.javatr.task1.generator;

public class IdGenerator {
    private long Id;

    public IdGenerator() {
        Id = 1;
    }

    public long generateId() {
        return Id++;
    }
}
