import edu.pattern.shapes.creator.ConeFactory;
import edu.pattern.shapes.creator.impl.ConeFactoryImpl;
import edu.pattern.shapes.model.Cone;
import edu.pattern.shapes.service.ConeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeServiceTest {

    ConeFactory factory = new ConeFactoryImpl();
    ConeService coneService = new ConeService();

    private final double[][] validCoordinates = {
            {0, 0, 3},
            {0, 0, 0},
            {0, 4, 0},
    };

    @Test
    public void testFindVolume() {
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(Math.PI * 16, coneService.findVolume(cone));
    }

    @Test
    public void testFindBaseSurface() {
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(Math.PI * 16, coneService.findBaseSurface(cone));
    }

    @Test
    public void testFindSideSurface() {
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(Math.PI * 20, coneService.findSideSurface(cone));
    }

    @Test
    public void testFindFullSurface() {
        Cone cone = factory.createConeByDoubles(validCoordinates);
        assertEquals(Math.PI * 36, coneService.findFullSurface(cone));
    }

}