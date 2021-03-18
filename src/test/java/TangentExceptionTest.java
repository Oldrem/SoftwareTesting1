import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TangentExceptionTest {
    private TangentSeries tangentSeries = new TangentSeries();
    @Test
    public void illegalArgumentTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tangentSeries.calculateTangentSeries(Math.PI/2);
        });
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            tangentSeries.calculateTangentSeries(-Math.PI/2);
        });
        assertEquals("Function does not exist in this point.", exception.getMessage());
        assertEquals("Function does not exist in this point.", exception2.getMessage());
    }
}
