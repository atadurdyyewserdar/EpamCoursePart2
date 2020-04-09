package main.by.javatr.task1.repository.specification;

import main.by.javatr.task1.entity.Quadrangle;
import main.by.javatr.task1.logic.QuadrangleCalculator;

public class QuadrangleTypeSpecification implements QuadrangleSpecification {

    private String quadrangleType;
    private QuadrangleCalculator quadrangleCalculator;

    public QuadrangleTypeSpecification(String quadrangleType, QuadrangleCalculator quadrangleCalculator) {
        this.quadrangleCalculator = quadrangleCalculator;
        this.quadrangleType = quadrangleType;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        String actualQuadrangleType = quadrangleCalculator.quadrangleType(quadrangle);
        return quadrangleType.equals(actualQuadrangleType);
    }
}
