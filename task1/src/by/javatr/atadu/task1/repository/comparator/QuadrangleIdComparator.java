package by.javatr.atadu.task1.repository.comparator;

import by.javatr.atadu.task1.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        return (int) (o1.getId() - o2.getId());
    }
}
