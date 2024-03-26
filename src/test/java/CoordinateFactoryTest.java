import edu.pattern.shapes.creator.CoordinateFactory;
import edu.pattern.shapes.creator.impl.CoordinateFactoryImpl;
import edu.pattern.shapes.model.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoordinateFactoryTest {
    CoordinateFactory factory = new CoordinateFactoryImpl();

    @Test
    public void testCreateCoordinatesArray() {
         double[][] validCoordinates = {
                        {0.0, 0.0, 0.0},
                        {1.0, 1.0, 1.0},
                        {2.0, 2.0, 2.0}
                };
        List<Coordinate> coordinates = factory.createCoordinatesArray(validCoordinates);
        assertEquals(3, coordinates.size());
    }
}
