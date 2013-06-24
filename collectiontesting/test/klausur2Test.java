/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static collectiontesting.klausur2.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sacry
 */
public class klausur2Test {

    public klausur2Test() {
    }

    @Test
    public void testInterleaveLists() {
        List<String> l1 = new ArrayList<>(Arrays.asList("ab", "cd"));
        List<String> l2 = new ArrayList<>(Arrays.asList("xy", "zu", "al"));
        List<String> l3 = new ArrayList<>();
        assertEquals(new ArrayList<>(Arrays.asList("ab", "xy", "cd", "zu", "al")), interleavelists(l1, l2));
        assertEquals(l1, interleavelists(l1, l3));
    }

    @Test(expected = NullPointerException.class)
    public void testFailInterleaveLists() {
        List<String> l1 = new ArrayList<>(Arrays.asList("ab", "cd"));
        List<String> l2 = new ArrayList<>(Arrays.asList("xy", "zu", "al"));
        assertEquals(new ArrayList<>(Arrays.asList("ab", "xy", "cd", "zu", "al")), interleavelists(l1, null));
    }

    @Test
    public void testMaxDepthOf() {
        List<String> l1 = new ArrayList<>(Arrays.asList("ab", "cd"));
        List<Object> l2 = new ArrayList<Object>(Arrays.asList("xy", "zu", "al"));
        List<Object> l3 = new ArrayList<>();
        l2.add(l1);
        l3.add(l2);
        assertEquals(3, maxDepthOf(l3));
        assertEquals(1, maxDepthOf(l1));
    }

    @Test(expected = NullPointerException.class)
    public void testFailMaxDepthOf() {
        assertEquals(1, maxDepthOf(null));
    }

    @Test
    public void testSetEqual() {
        Set<?> set1 = new HashSet<>(Arrays.asList("ab", "cd"));
        Set<?> set2 = new HashSet<>(Arrays.asList("ab", "cd"));
        Set<?> set3 = new HashSet<>(Arrays.asList("ab", "cy"));
        assertEquals(true, setEqual(set1, set1));
        assertEquals(true, setEqual(set1, set2));
        assertEquals(false, setEqual(set1, set3));
    }

    @Test
    public void testStringPairsToMap() {
        List<List<String>> l5 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab", "cd"), Arrays.asList("yx", "cd")));
        List<List<String>> l6 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab", "cd"), Arrays.asList("yx", "cd"),
                Arrays.asList("ab", "cd")));
        Map<String, String> m = new HashMap<>();
        m.put("ab", "cd");
        m.put("yx", "cd");
        assertEquals(m, stringPairsToMap(l5));
    }

    @Test(expected = NullPointerException.class)
    public void testNullStringPairsToMap() {
        List<List<String>> l5 = new ArrayList<>(null);
        assertEquals(null, stringPairsToMap(null));
        assertEquals(null, stringPairsToMap(l5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalStringPairsToMap() {
        List<List<String>> l5 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab"), Arrays.asList("yx", "cd")));
        assertEquals(null, stringPairsToMap(l5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegal2StringPairsToMap() {
        List<List<String>> l6 = new ArrayList<>(Arrays.asList(
                Arrays.asList("ab", "cd"), Arrays.asList("yx", "cd"),
                Arrays.asList("ab", "cd")));
        assertEquals(null, stringPairsToMap(l6));
    }
}