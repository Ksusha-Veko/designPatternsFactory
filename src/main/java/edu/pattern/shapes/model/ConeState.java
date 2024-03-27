package edu.pattern.shapes.model;

import edu.pattern.shapes.service.CoordinateService;

public enum ConeState {
    INVALID, VALID;
    public static ConeState detectConeState(Cone cone) {
        if (hasPerpendicularHeight(cone) == true && hasPositiveHeight(cone) == true){
        return VALID;
        }
        else{
            return INVALID;
        }
    }

    public static boolean hasPerpendicularHeight(Cone cone) {
        Coordinate oh = CoordinateService.findVector(cone.getO(), cone.getH());
        Coordinate ol = CoordinateService.findVector(cone.getO(), cone.getL());

        if (CoordinateService.vectorMultiplication(oh, ol) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean hasPositiveHeight(Cone cone) {
        Coordinate oh = CoordinateService.findVector(cone.getO(), cone.getH());
        if (oh.getZ() == 0 && oh.getY() == 0 && oh.getX() != 0||
        oh.getY() == 0 && oh.getX() == 0 && oh.getZ() != 0||
        oh.getX() == 0 && oh.getZ() == 0 && oh.getY() != 0){
           return true;
        }
        return false;
    }

}

