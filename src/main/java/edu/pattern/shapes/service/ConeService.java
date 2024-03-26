package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.Coordinate;

public class ConeService {
    public double findSideSurface(Cone cone) {
        Coordinate vectorLH = CoordinateService.findVector(cone.getL(), cone.getH());
        double sideLine = CoordinateService.findVectorModule(vectorLH);

        Coordinate vectorOL = CoordinateService.findVector(cone.getO(), cone.getL());
        double radius = CoordinateService.findVectorModule(vectorOL);

        return Math.PI * radius * sideLine;
    }

    public double findBaseSurface(Cone cone) {
        Coordinate vectorHL = CoordinateService.findVector(cone.getO(), cone.getL());
        double radius = CoordinateService.findVectorModule(vectorHL);

        return Math.PI * Math.pow(radius,2);
    }

    public double findFullSurface(Cone cone) {
        return findBaseSurface(cone) + findSideSurface(cone);
    }

    public double findVolume(Cone cone) {
        Coordinate vectorOH = CoordinateService.findVector(cone.getO(), cone.getH());
        double height = CoordinateService.findVectorModule(vectorOH);

        Coordinate vectorOL = CoordinateService.findVector(cone.getO(), cone.getL());
        double radius = CoordinateService.findVectorModule(vectorOL);
        return ((double) Math.pow(radius,2) * height * 1/3 * (double)Math.PI);
    }
}