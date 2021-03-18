
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static junit.framework.TestCase.assertTrue;
import static   org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TangentTest {
    private TangentSeries tangentSeries = new TangentSeries();
    private boolean checkTolerancy(double a, double b, double tolerancy){
        return (Math.abs(a-b) <= tolerancy);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TangentTestValues.csv")
    void testTangentFunction(double expected, double x){
        double value = tangentSeries.calculateTangentSeries(x);
        System.out.println("Value:" + value);
        System.out.println("Expected:" + expected);
        assertTrue(checkTolerancy(expected, value, 0.001));
    }

}
