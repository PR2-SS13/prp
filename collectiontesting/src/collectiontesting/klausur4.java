/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontesting;

import static com.google.common.base.Preconditions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sacry
 */
public class klausur4 {

    public static boolean isSorted(List<String> list) {

        checkNotNull(list);
        String next = list.get(0);

        for (String s : list) {
            if (next.compareTo(s) > 0) {
                return false;
            }
            next = s;
        }
        return true;
    }

    public static int noOfAllNodes(Set<?> aSet) {
        checkNotNull(aSet);
        int count = 0;
        for (Object o : aSet) {
            if (o instanceof Set) {
                count += noOfAllNodes((Set) o);
            } else {
                count += 1;
            }
        }
        return count;
    }

    public static Map<String, Integer> addFreqMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        checkNotNull(map1, map2);
        Map<String, Integer> freqMap = new HashMap<>(map1);
        for (String s : map2.keySet()) {
            int m2val = map2.get(s);
            freqMap.put(s, freqMap.containsKey(s) ? freqMap.get(s) + m2val : m2val);
        }
        return freqMap;
    }

    public static List<String> interleave(List<String> list1, List<String> list2) {
        checkNotNull(list1, list2);
        List<String> l = new ArrayList<>();

        Iterator<String> it1 = list1.iterator();
        Iterator<String> it2 = list2.iterator();

        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) {
                l.add(it1.next());
            }
            if (it2.hasNext()) {
                l.add(it2.next());
            }
        }

        return l;
    }
}
