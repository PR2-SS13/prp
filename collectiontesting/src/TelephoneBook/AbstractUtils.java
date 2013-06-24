/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBook;

/**
 *
 * @author sacry
 */
public abstract class AbstractUtils {

    protected static int hashDouble(String val) {
        long longBits = Double.doubleToLongBits(Double.valueOf(val));
        return (int) (longBits ^ (longBits >>> 32));
    }
}
