import edu.pattern.shapes.creator.ConeFactory;
import edu.pattern.shapes.creator.impl.ConeFactoryImpl;
import edu.pattern.shapes.exception.IncorrectConeDataException;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeFactoryTest {
    ConeFactory factory = new ConeFactoryImpl();
    private double[][] validCoordinates = {
            {0, 0, 3},
            {0, 0, 0},
            {0, 4, 0},
    };
    @Test
    public void testCreateConeByCoordinates() {
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(new Cone(new Coordinate(0,0,3), new Coordinate(0,0,0), new Coordinate(0,4,0)).getH(), cone.getH());
    }

    @Test
    public void testCreateConesByCoordinates() {
        Coordinate[][] coordinatesArray = {
                {new Coordinate(0, 0, 0), new Coordinate(1, 1, 1), new Coordinate(2, 2, 2)},
                {new Coordinate(3, 3, 3), new Coordinate(4, 4, 4), new Coordinate(5, 5, 5)}
        };

        List<Cone> cones = factory.createConesByCoordinates(coordinatesArray);
        assertEquals(2, cones.size());
    }

    @Test
    public void testCreateConeByDoubles(){
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(new Coordinate(0, 4, 0), cone.getL());
    }

    @Test
    public void testCreateConesByDoubles() {
        double[][][] doublesArray = {
                {
                        {0.0, 0.0, 0.0},
                        {1.0, 1.0, 1.0},
                        {2.0, 2.0, 2.0}
                },

                {
                        {3.0, 3.0, 3.0},
                        {4.0, 4.0, 4.0},
                        {5.0, 5.0, 5.0}
                },

                {
                        {3.0, 3.0, 3.0},
                        {4.0, 4.0, 4.0},
                        {5.0, 5.0, 5.0}
                },

                {
                        {3.0, 0.0, 0.0},
                        {4.0, 0.0, 4.0},
                        {5.0, 6.0, 7.0}
                }
        };

        List<Cone> cones = factory.createConesByDoubles(doublesArray);
        assertEquals(4, cones.size());
    }

    @Test
    public void testCreateConeByHeightCoordinateAndRadius(){
        Cone cone = factory.createConeByHeightCoordinateAndRadius(new Coordinate(0,0,10),5);
        assertEquals(new Coordinate(0, 0, 0), cone.getO());
    }

    @Test
    public void testCreateConeByHeightAndRadius(){
        Cone cone = factory.createConeByHeightAndRadius(10,5);
        assertEquals(new Coordinate(0, 0, 10), cone.getH());
    }

    @Test
    public void createConesFromFile() throws IncorrectConeDataException {
        ConeFactoryImpl factory = new ConeFactoryImpl();
        List<Cone> cones = factory.createConesFromFile("/rightCones.txt");
        assertEquals(8, cones.size());
    }

}
