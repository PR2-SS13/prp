/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static com.google.common.base.Preconditions.checkNotNull;
import java.math.BigDecimal;

/**
 *
 * @author SaCry
 */
public class myUtils {

    public static String reverse(String string) {
        checkNotNull(string);
        return new StringBuilder().append(string).reverse().toString();
    }

    public static double round(double unrounded, int precision) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
}
