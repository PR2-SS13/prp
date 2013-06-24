/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static collectiontesting.klausur1.compareCharList;
import static collectiontesting.klausur1.intMapToPairList;
import static collectiontesting.klausur1.listToMultiSet;
import static collectiontesting.klausur1.noOfDuplicateLeaves;
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
public class klausur1Test {

    public klausur1Test() {
    }

    @Test
    public void testCompareCharList() {
        ArrayList<Character> al1 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        ArrayList<Character> al2 = new ArrayList<>(Arrays.asList('b', 'c', 'd'));
        ArrayList<Character> al3 = new ArrayList<>(Arrays.asList('b', 'c', 'd', 'e'));
        assertEquals(0, compareCharList(al1, al1));
        assertEquals(-1, compareCharList(al1, al2));
        assertEquals(-1, compareCharList(al1, al3));
        assertEquals(1, compareCharList(al3, al1));
    }

    @Test(expected = NullPointerException.class)
    public void testNullCompareCharList() {
        compareCharList(new ArrayList<>(Arrays.asList('a', 'b', 'c')), null);
    }

    public void testNoOfDuplicateLeaves() {
        Set<Object> hs1 = new HashSet<Object>(Arrays.asList('a', 'b', 'c'));
        Set<Object> hs2 = new HashSet<Object>(Arrays.asList('a', 'b'));
        hs1.add(hs2);
        assertEquals(0, noOfDuplicateLeaves(hs2));
        assertEquals(2, noOfDuplicateLeaves(hs1));
    }

    @Test
    public void testIntMapToPairList() {
        Map<Integer, Integer> m = new HashMap<>();
        List<List<Integer>> l = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));
        m.put(1, 2);
        m.put(2, 3);
        assertEquals(new ArrayList<>(l), intMapToPairList(m));

    }

    @Test
    public void testListToMultiSet() {
        List<String> l = new ArrayList<>(Arrays.asList("ab", "ab", "ac", "ac", "ab", "x"));
        Map<String, Integer> m = new HashMap<>();
        m.put("ab", 3);
        m.put("ac", 2);
        m.put("x", 1);
        assertEquals(m, listToMultiSet(l));
    }
}