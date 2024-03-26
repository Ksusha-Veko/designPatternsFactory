package edu.pattern.shapes.creator;

import edu.pattern.shapes.exception.IncorrectConeDataException;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.Coordinate;
import java.util.List;

public interface ConeFactory {
    List<Cone> createConesByCoordinates(Coordinate[][] coordinatesArray);
    Cone createConeByCoordinates(Coordinate[] coordinatesArray);
    Cone createConeByDoubles(double[][] doublesArray);

    List<Cone> createConesByDoubles(double[][][] doublesArray);
    Cone createConeByHeightCoordinateAndRadius(Coordinate height, double radius);
    Cone createConeByHeightAndRadius(double height, double radius);
    List<Cone> createConesFromFile(String filePath) throws IncorrectConeDataException;
}