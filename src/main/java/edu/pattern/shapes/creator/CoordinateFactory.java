package edu.pattern.shapes.creator;
import edu.pattern.shapes.model.Coordinate;

import java.util.List;

public interface CoordinateFactory {
        List<Coordinate> createCoordinatesArray(double[][] coordinatesDouble);
}
