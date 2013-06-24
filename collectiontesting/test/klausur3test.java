/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static collectiontesting.klausur3.*;
import java.util.ArrayList;
import java.util.Arrays;
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
public class klausur3test {

    public klausur3test() {
    }

    @Test
    public void testdeepCopyTree() {
        Set<Object> s = new HashSet<Object>(Arrays.asList("a", "b", 1, new HashSet<Object>(Arrays.asList("h", 1))));
        assertEquals(s, deepCopyTree(s));
    }

    @Test
    public void testsetToMultiMap() {
        Set<List<String>> s = new HashSet<>(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("a", "m")));
        Map<String, List<String>> m = new HashMap<>();
        m.put("a", new ArrayList<>(Arrays.asList("b", "m")));
        assertEquals(m, setToMultiMap(s));
    }

    @Test
    public void testsymmDiff() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c"));
        assertEquals(new HashSet<>(Arrays.asList("a", "c")), symmDiff(s1, s2));
    }

    @Test
    public void testtransposeList() {
        List<List<String>> l1 = new ArrayList<>(Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("y", "m", "v")));
        List<List<String>> l2 = new ArrayList<>(Arrays.asList(Arrays.asList("a", "y"), Arrays.asList("b", "m"), Arrays.asList("c", "v")));
        assertEquals(l2, transposeList(l1));
        assertEquals(l1, transposeList(l2));
    }
}