/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import static com.google.common.base.Preconditions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sacry
 */
public class klausur3 {

    public static Set<?> deepCopyTree(Set<?> s) {

        checkNotNull(s);

        Set<Object> result = new HashSet<>();

        for (Object o : s) {
            if (o instanceof Set) {
                result.add(deepCopyTree((Set) o));
            } else {
                result.add(o);
            }
        }

        return result;
    }

    public static Map<String, List<String>> setToMultiMap(Set<List<String>> s) {

        checkNotNull(s);
        checkArgument(checkSetLength(s));

        Map<String, List<String>> m = new HashMap<>();

        for (List<String> l : s) {

            String key = l.get(0);
            ArrayList<String> temp = new ArrayList<>();

            if (m.containsKey(key)) {
                temp.addAll(m.get(key));
            }

            temp.addAll(l.subList(1, l.size()));
            m.put(key, temp);

        }

        return m;
    }

    public static Set<String> symmDiff(Set<String> s1, Set<String> s2) {
        checkNotNull(s1, s2);
        Set<String> intersection = new HashSet<>(s1);
        Set<String> union = new HashSet<>(s1);
        intersection.retainAll(s2);
        union.addAll(s2);
        Set<String> difference = new HashSet<>(union);
        difference.removeAll(intersection);
        return difference;
    }

    public static List<List<String>> transposeList(List<List<String>> l) {

        checkNotNull(l);
        checkArgument((l.get(0).size() > 0 || l.size() > 0));
        checkArgument(checkListLength(l));

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < l.get(0).size(); i++) {

            List<String> temp = new ArrayList<>();

            for (List<String> subl : l) {
                checkNotNull(subl);
                temp.add(subl.get(i));
            }
            result.add(temp);

        }

        return result;
    }

    private static boolean checkListLength(List<List<String>> l) {
        int first = l.get(0).size();
        for (List<String> subl : l) {
            if (first != subl.size()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSetLength(Set<List<String>> set) {
        for (List<String> subl : set) {
            checkNotNull(subl);
            if (subl.size() != 2) {
                return false;
            }
        }
        return true;
    }
}
