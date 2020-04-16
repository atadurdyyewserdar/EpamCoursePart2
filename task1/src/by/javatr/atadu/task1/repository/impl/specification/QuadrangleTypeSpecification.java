package by.javatr.atadu.task1.repository.impl.specification;

import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.logic.QuadrangleCalculator;
import by.javatr.atadu.task1.repository.QuadrangleSpecification;

public class QuadrangleTypeSpecification implements QuadrangleSpecification {

    private String quadrangleType;

    public QuadrangleTypeSpecification(String quadrangleType) {
        this.quadrangleType = quadrangleType;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();
        String actualQuadrangleType = quadrangleCalculator.quadrangleType(quadrangle);
        return quadrangleType.equals(actualQuadrangleType);
    }
}
