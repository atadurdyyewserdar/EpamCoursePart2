package by.javatr.atadu.task1.repository.impl.specification;

import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.repository.QuadrangleSpecification;

public class QuadrangleIdSpecification implements QuadrangleSpecification {
    private long id;

    public QuadrangleIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        return id == quadrangle.getId();
    }
}
