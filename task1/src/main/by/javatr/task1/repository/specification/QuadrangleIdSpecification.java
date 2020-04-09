package main.by.javatr.task1.repository.specification;

import main.by.javatr.task1.entity.Quadrangle;

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
