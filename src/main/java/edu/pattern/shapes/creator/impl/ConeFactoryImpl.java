package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.ConeFactory;
import edu.pattern.shapes.exception.IncorrectConeDataException;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.ConeState;
import edu.pattern.shapes.model.Coordinate;
import edu.pattern.shapes.reader.ConeFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class ConeFactoryImpl implements ConeFactory {
    public static final Logger logger = LogManager.getLogger(ConeFactoryImpl.class.getName());
    public Cone createConeByCoordinates(Coordinate[] coordinate)  {
            Cone cone = new Cone(coordinate[0], coordinate[1], coordinate[2]);
            ConeState currentState = ConeState.detectConeState(cone);
            cone.setState(currentState);
        logger.info("created a cone by coordinates" );
        return cone;
    }

    public List<Cone> createConesByCoordinates(Coordinate[][] coordinatesArray) {
        List<Cone> newCones = new ArrayList<>();
        for (Coordinate[] coordinate : coordinatesArray) {
        Cone cone = new Cone(coordinate[0], coordinate[1], coordinate[2]);
        ConeState currentState = ConeState.detectConeState(cone);
        cone.setState(currentState);
        newCones.add(cone);
        }
        logger.info( "created list of cones by coordinates: " + newCones );
        return newCones;
    }

    public Cone createConeByDoubles(double[][] doubles) {
            Coordinate coordinateH = new Coordinate(doubles[0][0], doubles[0][1], doubles[0][2]);
            Coordinate coordinateO = new Coordinate(doubles[1][0], doubles[1][1], doubles[1][2]);
            Coordinate coordinateL = new Coordinate(doubles[2][0], doubles[2][1], doubles[2][2]);

            Cone cone = new Cone(coordinateH, coordinateO, coordinateL);
            ConeState currentState = ConeState.detectConeState(cone);
            cone.setState(currentState);
        logger.info( "created a cone by doubles"  );
        return cone;
    }

    public List<Cone> createConesByDoubles(double[][][] doublesArray) {
        List<Cone> newCones = new ArrayList<>();
        for (double[][] doubles : doublesArray) {
            Coordinate coordinateH = new Coordinate(doubles[0][0], doubles[0][1], doubles[0][2]);
            Coordinate coordinateO = new Coordinate(doubles[1][0], doubles[1][1], doubles[1][2]);
            Coordinate coordinateL = new Coordinate(doubles[2][0], doubles[2][1], doubles[2][2]);

            Cone cone = new Cone(coordinateH, coordinateO, coordinateL);
            ConeState currentState = ConeState.detectConeState(cone);
            cone.setState(currentState);
            newCones.add(cone);
        }
        logger.info("created list of cones by doubles: " + newCones );
        return newCones;
    }



    public Cone createConeByHeightCoordinateAndRadius(Coordinate coordinateH, double radius)  {
        Coordinate coordinateO = new Coordinate(coordinateH.getX(), coordinateH.getY(), 0);
        Coordinate coordinateL = new Coordinate(coordinateO.getX() + radius, coordinateO.getY(),
                coordinateO.getZ());

        Cone cone = new Cone(coordinateH, coordinateO, coordinateL);
        ConeState currentState = ConeState.detectConeState(cone);
        cone.setState(currentState);
        logger.info("created a cone by coordinateH and radius" );
        return cone;
    }


    public Cone createConeByHeightAndRadius(double height, double radius) {
        Coordinate coordinateH = new Coordinate(0,0,height);
        Coordinate coordinateO = new Coordinate(coordinateH.getX(), coordinateH.getY(), 0);
        Coordinate coordinateL = new Coordinate(coordinateO.getX() + radius, coordinateO.getY(),
                coordinateO.getZ());

        Cone cone = new Cone(coordinateH, coordinateO, coordinateL);
        ConeState currentState = ConeState.detectConeState(cone);
        cone.setState(currentState);
        logger.info("created a cone by height and radius"  );
        return cone;
    }

    public List<Cone> createConesFromFile(String filePath) throws IncorrectConeDataException {
        List<Cone> cones = new ArrayList<>();
        ArrayList<Coordinate[]> coordinates = ConeFileReader.parseCoordinates(filePath);
        for (Coordinate[] coordinateCube: coordinates){
            Cone cone = createConeByCoordinates(coordinateCube);
            if (ConeState.detectConeState(cone) == ConeState.VALID){
                        cones.add(cone);
            }else{
                throw new IncorrectConeDataException("Incorrect cone data");
            }
        }
        return cones;
    }
}