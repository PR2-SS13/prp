/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.Collection;
import static com.google.common.base.Preconditions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author sacry
 */
public class extraExcercises {

    public static void main(String[] args) {
    }

    public static Collection<?> flatten(Collection<?> coll) {
        checkNotNull(coll);
        List<Object> accu = new ArrayList<>();
        flattenAcc(coll, accu);
        return accu;
    }

    private static void flattenAcc(Collection<?> coll, List<Object> accu) {
        for (Object o : coll) {
            if (o instanceof Collection) {
                flattenAcc((Collection) o, accu);
            } else {
                accu.add(o);
            }
        }
    }
  
}
