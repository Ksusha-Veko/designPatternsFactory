package edu.pattern.shapes.main;

import edu.pattern.shapes.creator.ConeFactory;
import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.creator.impl.ConeFactoryImpl;
import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.exception.IncorrectConeDataException;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.service.ConeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(ConeFactoryImpl.class.getName());
    public static void main(String[] args) throws IncorrectConeDataException {
        logger.info("Hello!");

        Coordinate[][] params =  new Coordinate[][]{
                {
                    new Coordinate(4, 5, 6), new Coordinate(4, 5, 0),
                        new Coordinate(0, 5, 0)
                },

                {
                        new Coordinate(13, 7, 25), new Coordinate(13, 7, 0),
                        new Coordinate(12, 7, 0)
                },

                {
                        new Coordinate(34, 24, 25), new Coordinate(34, 24, 7),
                        new Coordinate(14, 24, 7)}
        };

        ConeFactory factory = new ConeFactoryImpl();
        ConeService service = new ConeService();
        List<Cone> result = factory.createConesByCoordinates(params);
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        Cone ob = result.get(0);
        ob.setH(new Coordinate(1,2,3));
        System.out.println(warehouse);
        ob.setL(new Coordinate(2,3,4));
        System.out.println(warehouse);

        List<Cone> cones = factory.createConesFromFile("/cones.txt");
        System.out.println(cones);
    }
}


