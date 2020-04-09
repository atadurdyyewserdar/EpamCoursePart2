package main.by.javatr.task1.observer;

import main.by.javatr.task1.logic.QuadrangleCalculator;
import main.by.javatr.task1.observer.entity.QuadrangleData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer {
    private final static Logger logger = LogManager.getLogger();

    private final static Warehouse INSTANCE = new Warehouse();

    private Map<Long, QuadrangleData> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return INSTANCE;
    }

    public QuadrangleData getCalculation(long id) {
        return map.get(id);
    }

    @Override
    public void handleEvent(QuadrangleObservable item) {
        QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();
        String quadType = quadrangleCalculator.quadrangleType(item);
        double area = quadrangleCalculator.area(item);
        double perimeter = quadrangleCalculator.perimeter(item);
        QuadrangleData quadrangleData = new QuadrangleData(area, perimeter, quadType);
        map.put(item.getId(), quadrangleData);
        logger.info("Object updated - Id: " + item.getId());
    }
}
