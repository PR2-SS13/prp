/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static collectiontesting.extraExcercises.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author sacry
 */
public class extraExcercisesTest {

    public extraExcercisesTest() {
    }

    @Test
    public void testFlatten() {
        List<Object> l1 = new ArrayList<Object>(Arrays.asList("a", 1));
        assertEquals(l1, flatten(l1));
        List<Object> l2 = new ArrayList<Object>(Arrays.asList("h", 2));
        List<Object> l3 = new LinkedList<Object>(Arrays.asList("d", 3));
        List<Object> l4 = new LinkedList<Object>(Arrays.asList("c", 4));
        Set<Object> s1 = new HashSet<Object>(Arrays.asList("k", 5));
        Set<Object> s2 = new TreeSet<Object>(Arrays.asList(6, 6));
        l2.add(l3);
        l3.add(l4);
        l3.add(s2);
        l4.add(s1);
        s1.add(s2);
        l1.add(l2);
        List<Object> expectedResult = new ArrayList<Object>(
                Arrays.asList("a", 1, "h", 2, "d", 3, "c", 4, 6, "k", 5, 6));
        Collection<?> actualResult = flatten(l1);
        assert (actualResult.containsAll(actualResult) && actualResult.size() == expectedResult.size());
    }

}