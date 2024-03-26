package edu.pattern.shapes.reader;

import edu.pattern.shapes.exception.IncorrectCoordinateInputException;
import edu.pattern.shapes.model.Coordinate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.logging.Logger;
import java.util.logging.LogManager;


public class ConeFileReader {

    public static final int NUMBER_OF_COORDINATES = 3;
    public static final String DELIMETER_LINE = "; ";
    public static final String DELIMETER_ROW = ",";
    public static final Logger logger = LogManager.getLogManager().getLogger("ConeFileReader.class.getName()");



    public static ArrayList<Coordinate[]> parseCoordinates(String filePath) {
        ArrayList<Coordinate[]> parsedCoordinates = new ArrayList<>();
            try (Stream<String> lines = Files.lines(Paths.get(ConeFileReader.class.getResource(filePath).toURI()))) {
                lines.forEach(line -> {
                    String[] stringCoordinates = line.split(";");
                    if (stringCoordinates.length == NUMBER_OF_COORDINATES) {
                        Coordinate[] coordinates = new Coordinate[NUMBER_OF_COORDINATES];
                        for (int j = 0; j < NUMBER_OF_COORDINATES; j++) {
                            String[] xyz = stringCoordinates[j].split(",");
                            if (xyz.length == 3) {
                                try {
                                    double x = Double.parseDouble(xyz[0]);
                                    double y = Double.parseDouble(xyz[1]);
                                    double z = Double.parseDouble(xyz[2]);
                                    coordinates[j] = new Coordinate(x, y, z);
                                } catch (NumberFormatException e) {
                                    logger.info("cannot parse coordinates");
                                }
                            }
                        }
                        parsedCoordinates.add(coordinates);
                    }
                });
            } catch (IncorrectCoordinateInputException e) {
                logger.info("cannot parse coordinates");
            } catch (URISyntaxException e) {
                logger.info("cannot parse coordinates");
            } catch (IOException e) {
                logger.info("cannot parse coordinates");
            }
        return parsedCoordinates;
    }

}