package edu.pattern.shapes.reader;

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

    private static final int NUMBER_OF_COORDINATES = 3;
    private static final String DELIMITER_LINES = "; ";
    private static final String DELIMITER_ROW = ",";
    private static final Logger logger = LogManager.getLogManager().getLogger("ConeFileReader.class.getName()");



    public static ArrayList<Coordinate[]> parseCoordinates(String filePath) {
        ArrayList<Coordinate[]> parsedCoordinates = new ArrayList<>();
            try (Stream<String> lines = Files.lines(Paths.get(ConeFileReader.class.getResource(filePath).toURI()))) {
                lines.forEach(line -> {
                    String[] stringCoordinates = line.split(DELIMITER_LINES);
                    if (stringCoordinates.length == NUMBER_OF_COORDINATES) {
                        Coordinate[] coordinates = new Coordinate[NUMBER_OF_COORDINATES];
                        for (int j = 0; j < NUMBER_OF_COORDINATES; j++) {
                            String[] xyz = stringCoordinates[j].split(DELIMITER_ROW);
                            if (xyz.length == 3) {
                                try {
                                    double x = Double.parseDouble(xyz[0]);
                                    double y = Double.parseDouble(xyz[1]);
                                    double z = Double.parseDouble(xyz[2]);
                                    coordinates[j] = new Coordinate(x, y, z);
                                } catch (NumberFormatException e) {
                                    logger.error("cannot parse coordinates");
                                }
                            }
                        }
                        parsedCoordinates.add(coordinates);
                    }
                });
            } catch (IOException | URISyntaxException e) {
                logger.error("cannot parse coordinates");
            }
        return parsedCoordinates;
    }

}