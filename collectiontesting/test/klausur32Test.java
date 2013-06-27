/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static klausur3.klausur32.*;
import static org.junit.Assert.*;

/**
 *
 * @author sacry
 */
public class klausur32Test {

    public klausur32Test() {
    }

    @Test
    public void testTranspose() {
        List<List<String>> l2 = new ArrayList<>(Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("x", "y", "z")));
        List<List<String>> res = new ArrayList<>(Arrays.asList(Arrays.asList("a", "x"), Arrays.asList("b", "y"), Arrays.asList("c", "z")));
        assertEquals(res, transposeList(l2));
        res.add(Arrays.asList("u", "z"));
        assertNotSame(res, transposeList(l2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailTranspose() {
        List<List<String>> l = new ArrayList<>(Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("x", "y")));
        transposeList(l);
    }

    @Test
    public void testSymmDiff() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c"));
        Set<String> res = new HashSet<>(Arrays.asList("a", "c"));
        assertEquals(res, symmDiff(s1, s2));
        res.add("b");
        assertNotSame(res, symmDiff(s1, s2));
    }

    @Test
    public void testdeepCopyTree() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c"));
        Set<?> s3 = new HashSet<>(Arrays.asList("a", "c", s1, s2));
        assertEquals(s3, deepCopyTree(s3));
        assertNotSame(s2, symmDiff(s1, s2));
    }

    @Test
    public void testSetToMultiMap() {
        Set<List<String>> s = new HashSet<>(Arrays.asList(Arrays.asList("Emit", "PR1"),
                Arrays.asList("Otto", "PR2"), Arrays.asList("Emit", "AF")));
        Map<String, List<String>> res = new HashMap<>();
        res.put("Emit", Arrays.asList("PR1", "AF"));
        res.put("Otto", Arrays.asList("PR2"));
        assertEquals(res, setToMultiMap(s));

        Set<List<String>> s2 = new HashSet<>(Arrays.asList(Arrays.asList("Emit", "PR1"),
                Arrays.asList("Otto", "PR2"), Arrays.asList("Emit", "AF")));
        Map<String, List<String>> res2 = new HashMap<>();
        res.put("Emit", Arrays.asList("PR1"));
        res.put("Otto", Arrays.asList("PR2"));
        assertNotSame(res2, setToMultiMap(s2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailSetToMultiMap() {
        Set<List<String>> s = new HashSet<>(Arrays.asList(Arrays.asList("Emit", "PR1"),
                Arrays.asList("Otto", "PR2"), Arrays.asList("Emit")));
        setToMultiMap(s);
    }

}