package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.*;
import edu.pattern.shapes.observer.CoordinateObserver;
import edu.pattern.shapes.service.CoordinateService;

public class CoordinateObserverImpl implements CoordinateObserver {
    @Override
    public void update(Coordinate coordinate) {
        CoordinateService service = new CoordinateService();
        double vectorModule = CoordinateService.findVectorModule(coordinate);


        int key = coordinate.getCoordinateId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, new Double[]{vectorModule});

    }
}
