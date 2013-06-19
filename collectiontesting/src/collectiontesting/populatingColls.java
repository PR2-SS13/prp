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
        ArrayList<?> l3 = cLiAl(cLiAl("Layla", 1), cLiAl("the", 2), cLiAl("Lam", 3));
        // As Abstract
        Set<?> s1 = new HashSet(cLi(1, 2, 3, 4));
        Set<?> s2 = new TreeSet<>(cLi(1, 2, 3, 4));
        // As Abstract
        Map<?, ?> m1 = cMa(new HashMap<String, Integer>(),
                cLi("Layla", "the", "Lam"), cLi(5, 4, 3));
        Map<?, ?> m2 = cMa(new HashMap<String, Integer>(),
                cLi("Layla", "the", "Lam"), cLi(5, 4));
        Map<?, ?> m3 = cMa(new TreeMap<String, Integer>(),
                cLi("Layla", "the"), cLi(5, 4, 3));
    }

    public static List cLi(Object... elements) {
        return Arrays.asList(elements);
    }

    public static Map<?, ?> cMa(Map m, List<?> keys, List<?> values) {
        Iterator itval = values.iterator();
        for (Iterator<?> itkey = keys.iterator();
                itkey.hasNext() && itval.hasNext();) {
            m.put(itkey.next(), itval.next());
        }
        return m;
    }

    // Helpers
    public static ArrayList cLiAl(Object... elements) {
        ArrayList<?> al = new ArrayList<>(cLi(elements));
        return al;
    }

    public static void prLi(Collection<?> coll) {
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    public static void prM(Map<? extends Object, ? extends Object> m) {
        for (Map.Entry<? extends Object, ? extends Object> o : m.entrySet()) {
            System.out.println(o);
        }
    }

    public static HashMap<?, ?> cHmap(List<?> keys, List<?> values) {
        HashMap<?, ?> hm = new HashMap<>(cMa(new HashMap<String, Integer>(),
                keys, values));
        return hm;
    }
}
