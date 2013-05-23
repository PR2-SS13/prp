package implementation;

import java.math.BigDecimal;

/**
 *
 * @author abl563
 */
public class DoubleUtils {
    public static double round(double unrounded, int precision) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    } 
}
