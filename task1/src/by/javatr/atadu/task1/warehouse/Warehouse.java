package by.javatr.atadu.task1.warehouse;

import by.javatr.atadu.task1.entity.Quadrangle;
import by.javatr.atadu.task1.logic.QuadrangleCalculator;
import by.javatr.atadu.task1.observer.Observer;
import by.javatr.atadu.task1.observer.QuadrangleCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer {
    private static final Logger logger = LogManager.getLogger();
    private QuadrangleCalculator calculator = new QuadrangleCalculator();
    private Map<Long, QuadrangleCalculation> map = new HashMap<>();

    private static Warehouse instance = new Warehouse();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void putCalculation(long id, QuadrangleCalculation calculation) {
        map.put(id, calculation);
        logger.info("Object with id: " + id + " put in map");
    }

    public QuadrangleCalculation getCalculation(long id) {
        return map.get(id);
    }

    public void remove(long id) {
        map.remove(id);
        logger.info("Object with id: " + id + " removed from map");
    }

    @Override
    public void update(Quadrangle o) {
        double area = calculator.area(o);
        double perimeter = calculator.perimeter(o);
        String type = calculator.quadrangleType(o);
        map.put(o.getId(), new QuadrangleCalculation(area, perimeter, type));
        logger.info("Object with id: " + o.getId() + " was updated");
    }
}
