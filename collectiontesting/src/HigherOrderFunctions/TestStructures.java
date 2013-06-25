/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HigherOrderFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sacry
 */
public final class TestStructures {

    private TestStructures() {
    }

    public static List<Object> nOList(Object... o) {
        return new ArrayList<>(Arrays.asList(o));
    }

    public static Set<Object> nOSet(Object... o) {
        return new HashSet<>(Arrays.asList(o));
    }

    public static Collection<Object> nOColl(Collection<Object> coll, Object... o) {
        coll.addAll(Arrays.asList(o));
        return coll;
    }

    public static <T> List<T> nList(T... t) {
        return new ArrayList<>(Arrays.asList(t));
    }

    public static <T> Set<T> nSet(T... t) {
        return new HashSet<>(Arrays.asList(t));
    }

    public static <T> Collection<T> nColl(Collection<T> coll, T... t) {
        coll.addAll(Arrays.asList(t));
        return coll;
    }
}
