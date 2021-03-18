import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;
public class TangentSeries {

    public TangentSeries() {
    }

    public double adjustToSeriesBoundaries(double x){
        double delta = PI;

        if (x < 0)
            delta *= -1;

        while(abs(x) > PI/2)
            x -= delta;

        return x;
    }

    public double calculateTangentSeries(double point){

        double x = adjustToSeriesBoundaries(point);
        if (abs(x) == PI/2){
            throw new IllegalArgumentException("Function does not exist in this point.");
        }
        /*for (int i = 1; i <= n; i++){
            result+= ((pow(-1, n-1) * pow(x, 2*n - 1))/(factorial(2*n-1))) /
                    ((pow(-1, n) * pow(x, 2*n))/(factorial(2*n)));
        }*/
        double result = (x+(pow(x, 3)/3)+((2*pow(x, 5))/15)+((17*pow(x,7))/315)+((62*pow(x,9))/2835));
        return round(result, 6);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
