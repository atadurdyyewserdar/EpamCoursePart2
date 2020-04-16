package by.javatr.atadu.task1.repository.impl.specification;

import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.logic.QuadrangleCalculator;
import by.javatr.atadu.task1.repository.QuadrangleSpecification;

public class QuadrangleAreaSpecification implements QuadrangleSpecification {
    private double areaMin;
    private double areaMax;

    public QuadrangleAreaSpecification(double areaMin, double areaMax) {
        this.areaMin = areaMin;
        this.areaMax = areaMax;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double actualArea = calculator.area(quadrangle);
        return actualArea <= areaMax && actualArea >= areaMin;
    }
}
