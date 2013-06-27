/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klausur3;

import static com.google.common.base.Preconditions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sacry
 */
public class klausur32 {

    public static Map<String, List<String>> setToMultiMap(Set<List<String>> s) {
        checkSetToMultiMap(s);
        Map<String, List<String>> res = new HashMap<>();
        for (List<String> l : s) {
            String key = l.get(0), val = l.get(1);
            if (res.containsKey(key)) {
                List<String> temp = new ArrayList<>(res.get(key));
                temp.add(val);
                res.put(key, temp);
            } else {
                res.put(key, Arrays.asList(val));
            }
        }
        return res;
    }

    private static void checkSetToMultiMap(Set<List<String>> s) {
        checkNotNull(s);
        for (List<String> l : s) {
            checkNotNull(l);
            checkArgument(l.size() == 2);
        }
    }

    public static Set<?> deepCopyTree(Set<?> s) {
        checkNotNull(s);
        Set<Object> deepCopy = new HashSet<>();
        for (Object o : s) {
            if (o instanceof Set) {
                deepCopy.add((Set) o);
            } else {
                deepCopy.add(o);
            }
        }
        return deepCopy;
    }

    public static Set<String> symmDiff(Set<String> s1, Set<String> s2) {

        checkNotNull(s1, s2);
        Set<String> intersect = new HashSet<>(s1);
        Set<String> union = new HashSet<>(s1);

        intersect.retainAll(s2);
        union.addAll(s2);
        Set<String> difference = new HashSet<>(union);
        difference.removeAll(intersect);
        return difference;

    }

    public static List<List<String>> transposeList(List<List<String>> l) {
        int max = checkTranspose(l);
        List<List<String>> transposed = new ArrayList<>();
        for (int index = 0; index < max; index++) {

            List<String> temp = new ArrayList<>();
            for (List<String> ls : l) {
                temp.add(ls.get(index));
            }
            transposed.add(temp);

        }
        return transposed;
    }

    private static int checkTranspose(List<List<String>> l) {
        checkNotNull(l);
        int max = l.get(0).size();
        for (List<String> ls : l) {
            checkNotNull(ls);
            checkArgument(ls.size() == max);
        }
        return max;
    }
}
