/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author sacry
 */
public final class HigherOrderFunctions {

    private HigherOrderFunctions() {
    }

    // Reduce With 3 different Parameter Types
    public static <T, F> F reduce(ReduceFunction<T, F> red, F accu, List<T>... t) {
        for (List<T> elem : t) {
            accu = reduce(elem, red, accu);
        }
        return accu;
    }

    public static <T, F> F reduce(ReduceFunction<T, F> red, F accu, T... t) {
        for (T elem : t) {
            accu = red.apply(accu, elem);
        }
        return accu;
    }

    public static <T, F> F reduce(List<T> l, ReduceFunction<T, F> red, F accu) {
        for (T t : l) {
            accu = red.apply(accu, t);
        }
        return accu;
    }

    // Just to show how the function compositions could work
    public static <T> Collection<T> mapFilter(Collection<T> coll,
            Predicate<T> predicate, Function<T> funct) {
        Collection<T> coll2 = new ArrayList<>();
        for (T t : coll) {
            if (predicate.test(t)) {
                coll2.add(funct.apply(t));
            }
        }
        return coll2;
    }

    // Apply a function on a concrete Datatype. Note: has to be of Type T 
    // no casts required
    public static <T> List<T> map(List<T> list, Function<T> funct) {
        List<T> l = new ArrayList<>();
        for (T t : list) {
            l.add(funct.apply(t));
        }
        return l;
    }

    // Test a pridcate on a concrete Datatype.
    public static <T> List<T> filter(List<T> list,
            Predicate<T> predicate) {
        List<T> l = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                l.add(t);
            }
        }
        return l;
    }

    // Split one List into Two on a given predicate -> could be deduced to Object.
    public static <T> List<List<T>> partition(List<T> list,
            Predicate<T> predicate) {
        List<T> l1 = new ArrayList<>();
        List<T> l2 = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                l1.add(t);
            } else {
                l2.add(t);
            }
        }
        return new ArrayList<>(Arrays.asList(l1, l2));
    }

    // any/all -> Check predicate
    public static <T> boolean any(List<T> list,
            Predicate<T> predicate) {
        for (T t : list) {
            if (predicate.test(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean all(List<T> list,
            Predicate<T> predicate) {
        for (T t : list) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    // Yield first index for given predicate
    public static <T> int firstIndexFor(List<T> list,
            Predicate<T> predicate) {
        for (int index = 0; index < list.size(); index++) {
            if (predicate.test(list.get(index))) {
                return index;
            }
        }
        return -1;
    }
}
