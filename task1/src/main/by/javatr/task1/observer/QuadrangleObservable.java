package main.by.javatr.task1.observer;

import main.by.javatr.task1.entity.Point;
import main.by.javatr.task1.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleObservable extends Quadrangle implements Observable {
    List<Observer> observers = new ArrayList<>();

    public QuadrangleObservable(long id, Point a, Point b, Point c, Point d) {
        super(id, a, b, c, d);
    }

    @Override
    public void setA(Point a) {
        super.setA(a);
        notifyObservers();
    }

    @Override
    public void setB(Point b) {
        super.setB(b);
        notifyObservers();
    }

    @Override
    public void setC(Point c) {
        super.setC(c);
        notifyObservers();
    }

    @Override
    public void setD(Point d) {
        super.setD(d);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent(this);
        }
    }
}
