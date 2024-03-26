import edu.pattern.shapes.creator.ConeFactory;
import edu.pattern.shapes.creator.impl.ConeFactoryImpl;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeTest {

    ConeFactory factory = new ConeFactoryImpl();


    private double[][] validCoordinates = {
            {0, 0, 10},
            {0, 0, 0},
            {0, 5, 0},
    };
    Cone cone = factory.createConeByDoubles(validCoordinates);

    @Test
    public void testSetH() {
        assertEquals(new Coordinate(0,0,10), cone.getH());
    }

    @Test
    public void testSetO() {
        assertEquals(new Coordinate(0,0,0), cone.getO());
    }

    @Test
    public void testSetL() {
        assertEquals(new Coordinate(0,5,0), cone.getL());
    }
}