import edu.pattern.shapes.creator.impl.ConeFactoryImpl;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.model.ConeState;
import edu.pattern.shapes.creator.ConeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeStateTest {

    ConeFactory factory = new ConeFactoryImpl();

    private double[][] firstSetOfCoordinates = {
            {0, 0, 5},
            {0, 0, 0},
            {0, 5, 0},
    };

    double[][] secondSetCoordinates = {
            {0, 0, 0},
            {1, 1, 2},
            {1, 0, 1},
    };
    double[][] thirdSetCoordinates = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
    };


    @Test
    public void testDetectValidCone() {
        Cone cone = factory.createConeByDoubles(firstSetOfCoordinates);
        assertEquals(ConeState.VALID, ConeState.detectConeState(cone));
    }

    @Test
    public void testDetectInvalidConeOnHeightDifference() {
        Cone cone = factory.createConeByDoubles(secondSetCoordinates);
        assertEquals(ConeState.INVALID, ConeState.detectConeState(cone));
    }
    @Test
    public void testDetectInvalidConeOnOneCoordinate() {
        Cone cone = factory.createConeByDoubles(thirdSetCoordinates);
        assertEquals(ConeState.INVALID, ConeState.detectConeState(cone));
    }
}