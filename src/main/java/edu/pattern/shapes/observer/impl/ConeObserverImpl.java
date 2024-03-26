package edu.pattern.shapes.observer.impl;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.ConeState;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.ConeObserver;
import edu.pattern.shapes.service.ConeService;

public class ConeObserverImpl implements ConeObserver {
    @Override
    public void update(Cone cone) {
        ConeState state = ConeState.detectConeState(cone);
        ConeService service = new ConeService();
        double baseSurface = service.findBaseSurface(cone);
        double sideSurface = service.findSideSurface(cone);
        double fullSurface = service.findFullSurface(cone);
        double volume = service.findVolume(cone);


        int key = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, new Double[]{baseSurface,sideSurface,fullSurface,volume});

    }


}

