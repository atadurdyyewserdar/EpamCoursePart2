package by.javatr.atadu.task1.repository;

import by.javatr.atadu.task1.entity.Quadrangle;

import java.util.Comparator;
import java.util.List;

public interface QuadrangleRepository {
    boolean addQuadrangle(Quadrangle quadrangle);

    boolean deleteQuadrangle(Quadrangle quadrangle);

    List<Quadrangle> query(QuadrangleSpecification quadrangleSpecification);

    void sort(Comparator<? super Quadrangle> comparator);
}
