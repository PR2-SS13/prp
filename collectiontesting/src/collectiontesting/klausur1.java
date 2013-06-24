/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

/**
 *
 * @author sacry
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static com.google.common.base.Preconditions.*;

public class klausur1 {

    public static void main(String[] args) {
        // 1
        ArrayList<Character> al1 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        ArrayList<Character> al2 = new ArrayList<>(Arrays.asList('b', 'c', 'd'));
        System.out.println(compareCharList(al1, al2));
        // 2
        Set<Object> hs1 = new HashSet<Object>(Arrays.asList('a', 'b', 'c'));
        Set<Object> hs2 = new HashSet<Object>(Arrays.asList('a', 'b'));
        hs1.add(hs2);
        System.out.println(noOfDuplicateLeaves(hs1));
        // 3
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 3);
        m.put(3, 4);
        m.put(4, 5);
        System.out.println(intMapToPairList(m));
        // 4
        List<String> l = new ArrayList<>(Arrays.asList("ab", "ab", "ac", "ac", "ab", "x"));
        System.out.println(listToMultiSet(l));
    }

    public static Map<String, Integer> listToMultiSet(List<String> list) {
        checkNotNull(list);
        Map<String, Integer> m = new HashMap<>();
        for (String s : list) {
            m.put(s, m.containsKey(s) ? m.get(s) + 1 : 1);
        }
        return m;
    }

    public static List<ArrayList<Integer>> intMapToPairList(Map<Integer, Integer> m) {
        checkNotNull(m);
        List<ArrayList<Integer>> l1 = new ArrayList<>();
        for (Integer i : m.keySet()) {
            l1.add(new ArrayList<>(Arrays.asList(i, m.get(i))));
        }
        return l1;
    }

    public static int compareCharList(List<Character> l1, List<Character> l2) {
        checkNotNull(l1, l2);
        Iterator<Character> i1 = l1.iterator();
        Iterator<Character> i2 = l2.iterator();
        while (i1.hasNext() && i2.hasNext()) {
            char c1 = i1.next(), c2 = i2.next();
            if (c1 > c2) {
                return 1;
            }
            if (c1 < c2) {
                return -1;
            }
        }
        if (i1.hasNext()) {
            return 1;
        }
        if (i2.hasNext()) {
            return -1;
        }
        return 0;
    }

    public static int noOfDuplicateLeaves(Set<?> aSet) {
        checkNotNull(aSet);
        int res = 0;
        Map<Object, Integer> count = new HashMap<>();
        noOfDuplicateLeaves(aSet, count);
        for (Integer o : count.values()) {
            if (o > 1) {
                res++;
            }
        }
        return res;
    }

    public static void noOfDuplicateLeaves(Set<?> aSet, Map<Object, Integer> count) {
        for (Object o : aSet) {
            if (o instanceof Set) {
                noOfDuplicateLeaves((Set<?>) o, count);
            } else {
                count.put(o, count.containsKey(o) ? count.get(o) + 1 : 1);
            }
        }
    }
    
    
}
