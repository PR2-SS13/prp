/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author sacry
 */
public class CollectionExcercises {

    public static void main(String[] args) {

        Collection<Object> coll1 = new ArrayList<Object>(asList("a", "b"));
        Collection<Object> coll2 = new ArrayList<Object>(asList("a", "b"));
        Collection<Object> coll3 = new LinkedList<Object>(asList("a", "b"));
        Collection<Object> coll4 = new ArrayList<Object>(asList("a", "b"));
        coll2.add(coll3);
        coll1.add(coll2);
        coll3.add(coll4);
        System.out.println(maxDebth(coll1));

        List<Object> l1 = new ArrayList<Object>(asList("e", "f"));
        List<Object> l2 = new ArrayList<>(asList("c", "d", l1));
        List<Object> l3 = new ArrayList<Object>(asList("g", "h"));
        Set<Object> s1 = new HashSet<>(asList("x", "y", l3, l2));
        List<Object> l4 = new LinkedList<>(asList("5", "7", s1));
        List<Object> l5 = new LinkedList<>(asList("a", "b", l1, l2, s1, l4));

        Set<Object> s3 = new HashSet<Object>(asList("x", "y", "z", "a", "b"));
        Set<Object> s4 = new HashSet<Object>(asList("x", "y", "z", "c", "d"));
        System.out.println("union: " + union(s3, s4));
        System.out.println("intersection: " + intersection(s3, s4));
        System.out.println("difference: " + difference(s3, s4));
        System.out.println("asymdiff: " + asymdiff(s3, s4));

        List<? extends Comparable> l = new ArrayList<>(asList(5, 4, 3, 2, 1));
        List<Integer> al = new ArrayList<>(asList(5, 4, 3, 2, 1, 2, 3, 4));
        mysort(al);
        System.out.println(mysort(al));

        List<Object> al2 = new ArrayList<Object>(asList(110, 1, 5, 6, 6,
                4, 3, 4, 1, 3, 2, 1, 2, 3, 4));
        System.out.println(immuUnique(al2));
        System.out.println(al2);
        mutaUnique(al2);
        System.out.println(al2);
        System.out.println(mergeTwoAndSort(al2, al2));


        List<Object> al3 = new ArrayList<Object>(asList(110, 1, 5, 6, 6,
                4, 3, 4, 1, 3, 2, 1, 2, 3, 4));
        List<Object> al4 = new ArrayList<Object>(asList(110, 1, 5, 6, 6,
                4, 3, 4, 1, 3, 2, 1, 2, 3, 4));
        System.out.println(myShuffle(al3, al4));
        System.out.println(reverseList(al4));
        System.out.println(splitInTwo(al4));
        System.out.println(splitInTwoReverse(al4));
        Map<Object, Object> m1 = new HashMap<>();
        Map<Object, Object> m2 = new HashMap<>();
        m1.put("w00t", 1);
        m1.put("asr", 1);
        m1.put("trg", 1);
        m2.put("w00t", 1);
        m2.put("asr", 2);
        m2.put("trga", 1);
        System.out.println(sameInMap(m1, m2));
        System.out.println(sameInKeyMap(m1, m2));
    }
    
    public static Map<Object, Object> sameInKeyMap(Map<Object, Object> m1, Map<Object, Object> m2) {
        Map<Object, Object> m3 = new HashMap<>();
        for (Object o : m2.keySet()) {
            if (m1.containsKey(o)) {
                m3.put(o, m1.get(o));
            }
        }
        return m3;
    }

    public static Map<Object, Object> sameInMap(Map<Object, Object> m1, Map<Object, Object> m2) {
        Map<Object, Object> m3 = new HashMap<>();
        for (Object o : m2.keySet()) {
            if (m1.containsKey(o) && m1.get(o) == m2.get(o)) {
                m3.put(o, m1.get(o));
            }
        }
        return m3;
    }

    public static List<Object> splitInTwoReverse(List<Object> l) {
        return reverseList(splitInTwo(l));
    }

    public static List<Object> splitInTwo(List<Object> l) {
        List<Object> l2 = new ArrayList<>();
        l2.add(l.subList(0, l.size() / 2));
        l2.add(l.subList(l.size() / 2, l.size()));
        return l2;
    }

    public static List<Object> mergeTwoAndSort(
            List<Object> l, List<Object> l2) {
        List<Object> l3 = new ArrayList<>(l2);
        l3.addAll(l2);
        mutaUnique(l3);
        return l3;
    }

    public static List<Object> reverseList(List<Object> l) {
        List<Object> l2 = new ArrayList<>(l);
        Collections.reverse(l2);
        return l2;
    }

    public static List<Object> myShuffle(
            List<Object> l, List<Object> l2) {
        List<Object> l3 = new ArrayList<>(l2);
        l3.addAll(l2);
        mutaUnique(l3);
        Collections.shuffle(l3);
        return l3;
    }

    public static List<Object> immuUnique(List<Object> al) {
        return new ArrayList<>(asList(new TreeSet<>(asList(al.toArray())).toArray()));
    }

    public static void mutaUnique(List<Object> al) {
        List<Object> l = immuUnique(al);
        al.clear();
        al.addAll(l);
    }

    public static Set<Object> union(Set<Object> s1, Set<Object> s2) {
        Set<Object> s3 = new HashSet<>(s1);
        s3.addAll(s2);
        return s3;
    }

    public static Set<Object> intersection(Set<Object> s1, Set<Object> s2) {
        Set<Object> s3 = new HashSet<>(s1);
        s3.retainAll(s2);
        return s3;
    }

    public static Set<Object> difference(Set<Object> s1, Set<Object> s2) {
        Set<Object> s3 = new HashSet<>(s1);
        s3.removeAll(s2);
        return s3;
    }

    public static Set<Object> asymdiff(Set<Object> s1, Set<Object> s2) {
        return difference(union(s1, s2), intersection(s1, s2));
    }

    public static List<Integer> mysort(List<Integer> l) {
        List<Integer> l2 = new ArrayList<>(l);
        Collections.sort(l2);
        return l2;
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
}
