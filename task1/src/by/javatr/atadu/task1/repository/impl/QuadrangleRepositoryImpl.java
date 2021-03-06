package by.javatr.atadu.task1.repository.impl;

import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.repository.QuadrangleRepository;
import by.javatr.atadu.task1.repository.QuadrangleSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepositoryImpl implements QuadrangleRepository {
    List<Quadrangle> quadrangles = new ArrayList<>();

    public QuadrangleRepositoryImpl() {
    }

    @Override
    public boolean addQuadrangle(Quadrangle quadrangle) {
        return quadrangles.add(quadrangle);
    }

    @Override
    public boolean deleteQuadrangle(Quadrangle quadrangle) {
        return quadrangles.remove(quadrangle);
    }

    @Override
    public List<Quadrangle> query(QuadrangleSpecification quadrangleSpecification) {
        return quadrangles.stream()
                .filter(quadrangleSpecification::specified)
                .collect(Collectors.toList());
    }

    @Override
    public void sort(Comparator<? super Quadrangle> comparator) {
        quadrangles.sort(comparator);
    }
}
