package edu.pattern.shapes.observer;

import edu.pattern.shapes.model.Coordinate;

public interface CoordinateObserver {
    void update(Coordinate coordinate);
}
