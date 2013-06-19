/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import static com.google.common.base.Preconditions.*;
import static collectiontesting.populatingColls.*;
import java.util.HashMap;

/**
 *
 * @author sacry
 */
public class invaraiantChecks {

    public static void main(String[] args) {
        int i = 2, j = 3;
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
        checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
        checkNotNull(j);
        System.out.println("Success!");
        HashMap<?, ?> m = cHmap(cLi("Layla", "the", "Lam"), cLi(1, 2, 3));
    }
}
