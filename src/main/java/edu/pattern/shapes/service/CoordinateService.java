package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Coordinate;


public class CoordinateService {
    public static double vectorMultiplication(Coordinate vector1, Coordinate vector2){
        return vector1.getX()*vector2.getX() + vector1.getY()*vector2.getY() +
                vector1.getZ()*vector2.getZ();
    }

    public static Coordinate findVector(Coordinate coordinate1, Coordinate coordinate2) {
            return new Coordinate(coordinate1.getX() - coordinate2.getX(), coordinate1.getY() - coordinate2.getY(),
                    coordinate1.getZ() - coordinate2.getZ());
    }



    public static double findVectorModule(Coordinate vector1){
        return Math.sqrt(Math.pow(vector1.getX(), 2) + Math.pow(vector1.getY(), 2) + Math.pow(vector1.getZ(),2));
    }
}
