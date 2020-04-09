package main.by.javatr.task1.repository;

import main.by.javatr.task1.entity.Quadrangle;
import main.by.javatr.task1.repository.specification.QuadrangleSpecification;

import java.util.Comparator;
import java.util.List;

public interface QuadrangleRepository {
    boolean addQuadrangle(Quadrangle quadrangle);

    boolean deleteQuadrangle(Quadrangle quadrangle);

    List<Quadrangle> query(QuadrangleSpecification quadrangleSpecification);

    public void sort(Comparator<? super Quadrangle> comparator);
}
