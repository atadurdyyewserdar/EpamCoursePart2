package by.javatr.atadu.task1.entity;

import by.javatr.atadu.task1.observer.Observable;
import by.javatr.atadu.task1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle implements Observable {
    private long id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    List<Observer> observerList = new ArrayList<>();

    public Quadrangle() {
    }

    public Quadrangle(long id, Point a, Point b, Point c, Point d) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObservers();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObservers();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObservers();
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) o;
        return a.equals(quadrangle.getA())
                && b.equals(quadrangle.getB())
                && c.equals(quadrangle.getC())
                && d.equals(quadrangle.getD());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result += prime * id
                + prime * a.hashCode()
                + prime * b.hashCode()
                + prime * c.hashCode()
                + prime * d.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder("Quadrangle { ")
                .append("id = ").append(id)
                .append(", a = ").append(a)
                .append(", b = ").append(b)
                .append(", c = ").append(c)
                .append(", d = ").append(d)
                .append(" }")
                .toString();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
