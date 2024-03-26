package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinateFactoryImpl implements CoordinateFactory {
    public List<Coordinate> createCoordinatesArray(double[][] coordinates){
        List<Coordinate> newCoordinates = new ArrayList<>();
        for (double[] coordinateDouble : coordinates) {
            Coordinate coordinate1 = new Coordinate(coordinateDouble[0], coordinateDouble[1], coordinateDouble[2]);
            newCoordinates.add(coordinate1);
        }
        return newCoordinates;
    }

}
