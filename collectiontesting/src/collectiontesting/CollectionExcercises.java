/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import static com.google.common.base.Preconditions.*;
import java.util.Collections;

/**
 *
 * @author sacry
 */
public class CollectionExcercises {

    public static void main(String[] args) {

        Collection<Object> coll1 = new ArrayList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll2 = new ArrayList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll3 = new LinkedList<Object>(Arrays.asList("a", "b"));
        Collection<Object> coll4 = new ArrayList<Object>(Arrays.asList("a", "b"));
        coll2.add(coll3);
        coll1.add(coll2);
        coll3.add(coll4);
        System.out.println(maxDebth(coll1));

        List<Object> l1 = new ArrayList<Object>(Arrays.asList("e", "f"));
        List<Object> l2 = new ArrayList<>(Arrays.asList("c", "d", l1));
        List<Object> l3 = new ArrayList<Object>(Arrays.asList("g", "h"));
        Set<Object> s1 = new HashSet<>(Arrays.asList("x", "y", l3, l2));
        List<Object> l4 = new LinkedList<>(Arrays.asList("5", "7", s1));
        List<Object> l5 = new LinkedList<>(Arrays.asList("a", "b", l1, l2, s1, l4));

        System.out.println(l5);
        System.out.println(deepReverse(l5));
        mutableReverse(l5);
        System.out.println(l5);
    }

    public static int maxDebth(Collection<?> coll) {
        int max = 0;
        for (Object o : coll) {
            if (o instanceof Collection) {
                max = Math.max(maxDebth((Collection<?>) o) + 1, max);
            }
        }
        return max;
    }

    // Mutable is not cast to any concrete collections subclass and stays as is...
    public static void mutableReverse(Collection<Object> coll) {
        if (coll instanceof List) {
            Collections.reverse((List<Object>) coll);
        }
        for (Object o : coll) {
            if (o instanceof List) {
                mutableReverse((List<Object>) o);
            } else if (o instanceof Set) {
                mutableReverse((Set<Object>) o);
            }
        }
    }

    // On List, doesn't touch any Set types..
    public static List<Object> deepReverse(List<Object> list) {
        List<Object> al = new ArrayList<>();
        for (ListIterator iterator = list.listIterator(list.size());
                iterator.hasPrevious();) {
            Object listElement = iterator.previous();
            if (listElement instanceof List) {
                al.add(deepReverse((List<Object>) listElement));
            } else {
                al.add(listElement);
            }
        }
        return al;
    }
}
