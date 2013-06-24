/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static collectiontesting.klausur4.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sacry
 */
public class klausur4Test {

    public klausur4Test() {
    }

    @Test
    public void testisSorted() {
        List<String> l = new ArrayList<>(Arrays.asList("ab", "bc", "c"));
        assertEquals(true, isSorted(l));
        Collections.reverse(l);
        assertEquals(false, isSorted(l));
    }

    @Test
    public void testnoOfAllNodes() {
        Set<?> s = new HashSet<>(
                new HashSet<>(Arrays.asList("a", "b",
                new HashSet<>(Arrays.asList("a", "b",
                new HashSet<>(Arrays.asList("a", "b")))))));
        assertEquals(6, noOfAllNodes(s));
    }

    @Test
    public void testaddFreqMaps() {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("a", 5);
        m1.put("b", 5);
        m1.put("c", 5);
        Map<String, Integer> m2 = new HashMap<>(m1);
        m2.put("d", 5);
        Map<String, Integer> m3 = new HashMap<>();
        m3.put("a", 10);
        m3.put("b", 10);
        m3.put("c", 10);
        m3.put("d", 5);
        assertEquals(m3, addFreqMaps(m1, m2));
    }

    @Test
    public void testinterleave() {
        List<String> l1 = new ArrayList<>(Arrays.asList("a","c","e"));
        List<String> l2 = new ArrayList<>(Arrays.asList("b","d"));
        assertEquals(Arrays.asList("a","b","c","d","e"), interleave(l1, l2));
    }
}