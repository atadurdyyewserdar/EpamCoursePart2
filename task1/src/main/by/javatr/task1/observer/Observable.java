package main.by.javatr.task1.observer;

public interface Observable {
    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifyObservers();
}
