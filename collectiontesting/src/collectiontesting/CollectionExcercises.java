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


        Set<Object> s3 = new HashSet<Object>(Arrays.asList("x", "y", "z", "a", "b"));
        Set<Object> s4 = new HashSet<Object>(Arrays.asList("x", "y", "z", "c", "d"));
        System.out.println("union: " + union(s3, s4));
        System.out.println("intersection: " + intersection(s3, s4));
        System.out.println("difference: " + difference(s3, s4));
        System.out.println("asymdiff: " + asymdiff(s3, s4));
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
