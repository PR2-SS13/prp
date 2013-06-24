/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import static com.google.common.base.Preconditions.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sacry
 */
public class klausur2 {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(Arrays.asList("ab", "cd"));
        List<String> l2 = new ArrayList<>(Arrays.asList("xy", "zu", "al"));
        System.out.println(interleavelists(l1, l2));

        List<Object> l3 = new ArrayList<>(Arrays.asList("ab", "cd", l1));
        List<Object> l4 = new ArrayList<>(Arrays.asList("xy", "zu", "al", l3));
        System.out.println(maxDepthOf(l4));

        Set<?> set1 = new HashSet<>(Arrays.asList("ab", "cd", l1));
        Set<?> set2 = new HashSet<>(Arrays.asList("ab", "cd", l1));
        Set<?> set3 = new HashSet<>(Arrays.asList("ab", "cd"));
        System.out.println(setEqual(set1, set1));
        System.out.println(setEqual(set1, set2));
        System.out.println(setEqual(set1, set3));

        List<List<String>> l5 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab", "cd"), Arrays.asList("yx", "cd")));
        List<List<String>> l6 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab", "cd"), Arrays.asList("yx", "cd"),
                Arrays.asList("ab", "cd")));
        System.out.println(stringPairsToMap(l5));
        System.out.println(stringPairsToMap(l6));
    }

    public static List<String> interleavelists(List<String> list1, List<String> list2) {
        checkNotNull(list1, list2);
        List<String> l = new ArrayList<>();
        Iterator<String> it2 = list2.iterator();
        for (Iterator<String> it1 = list1.iterator(); it1.hasNext() || it2.hasNext();) {
            if (it1.hasNext()) {
                l.add(it1.next());
            }
            if (it2.hasNext()) {
                l.add(it2.next());
            }
        }
        return l;
    }

    public static int maxDepthOf(Collection<?> aColl) {
        checkNotNull(aColl);
        if (aColl.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (Object o : aColl) {
            max = Math.max(max, (o instanceof Collection) ? maxDepthOf((Collection<?>) o) + 1 : 1);
        }
        return max;
    }

    public static boolean setEqual(Set<?> set, Object obj) {
        if (obj == set) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set<?> set2 = (Set<?>) obj;
        if (set.size() != set2.size()) {
            return false;
        }
        for (Object o : set) {
            if (!set2.contains(o)) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, String> stringPairsToMap(List<List<String>> list) {

        checkNotNull(list);

        Map<String, String> m = new HashMap<>();

        for (List<String> l : list) {

            checkNotNull(l);
            checkArgument(l.size() == 2);

            String key = l.get(0), val = l.get(1);

            checkArgument(!m.containsKey(key));

            m.put(key, val);

        }

        return m;

    }
}
