import edu.pattern.shapes.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    Coordinate coordinate = new Coordinate(0.0, 0.4, 0.5);
    @Test
    public void testSetX() {
        assertEquals(0.0, coordinate.getX());
    }

    @Test
    public void testSetY() {
        assertEquals(0.4, coordinate.getY());
    }

    @Test
    public void testSetZ() {
        assertEquals(0.5, coordinate.getZ());
    }
}