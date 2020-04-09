package main.by.javatr.task1.repository.specification;

import main.by.javatr.task1.entity.Quadrangle;
import main.by.javatr.task1.logic.QuadrangleCalculator;

public class QuadrangleAreaSpecification implements QuadrangleSpecification {
    private double areaMin;
    private double areaMax;
    private QuadrangleCalculator quadrangleCalculator;

    public QuadrangleAreaSpecification(double areaMin, double areaMax, QuadrangleCalculator quadrangleCalculator) {
        this.areaMin = areaMin;
        this.areaMax = areaMax;
        this.quadrangleCalculator = quadrangleCalculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        double actualArea = quadrangleCalculator.area(quadrangle);
        return actualArea <= areaMax && actualArea >= areaMin;
    }
}
