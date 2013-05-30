/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static com.google.common.base.Preconditions.*;

/**
 *
 * @author abl563
 */
public class StringUtils {

    public static String reverse(String string) {
        checkNotNull(string);
        return new StringBuilder().append(string).reverse().toString();
    }
}
