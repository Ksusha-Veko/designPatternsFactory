package edu.pattern.shapes.exception;

import java.io.IOException;

public class IncorrectCoordinateInputException extends IOException {
    public IncorrectCoordinateInputException(String message) {
        super(message);
    }
}
