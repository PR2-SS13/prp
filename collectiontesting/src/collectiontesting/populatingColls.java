/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author sacry
 */
public class populatingColls {

    public static void main(String[] args) {
        // As Absract
        List<?> l1 = new ArrayList<>(cLi("Layla", "the", "Lam"));
        List<?> l2 = new LinkedList<>(cLi("Layla", "the", "Lam"));
        // Concrete
        List<?> l3 = cLi(cLi("Layla", 1), cLi("the", 2), cLi("Lam", 3));
        // As Abstract
        Set<?> s1 = new HashSet(cLi(1, 2, 3, 4));
        Set<?> s2 = new TreeSet<>(cLi(1, 2, 3, 4));
        // As Abstract
        Map<?, ?> m1 = cMap(cLi("Layla", "the"), cLi(5, 4, 3));
        prM(m1);

    }

    public static <K, V> Map<K, V> cMap(List<K> keys, List<V> values) {
        Map<K, V> m = new HashMap<>();
        Iterator<K> itkey = keys.iterator();
        Iterator<V> itval = values.iterator();
        while (itkey.hasNext() && itval.hasNext()) {
            m.put(itkey.next(), itval.next());
        }
        return m;
    }

    public static <T> List cLi(T... elements) {
        return Arrays.asList(elements);
    }

    // Printers
    public static <T> void prLi(Collection<T> coll) {
        for (T t : coll) {
            System.out.println(t);
        }
    }

    public static <K, V> void prM(Map<K, V> m) {
        for (Map.Entry<K, V> entry : m.entrySet()) {
            System.out.println(entry);
        }
    }
}
