/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.Values.*;

import interfaces.physics.Force;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class ForceInNTest {

    public ForceInNTest() {
    }

    /**
     * Test of n method, of class ForceInN.
     */
    @Test
    public void testNewton() {
        System.out.println("Newton");
        Force f0 = forceInN(10);     // 10n
        assertEquals(10, f0.newton(), 0);        // 10n
        Force f1 = forceInN(-10);     // 10n
        assertEquals(-10, f1.newton(), 0);        // 10n
    }

    /**
     * Test of inverse method, of class ForceInN.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Force f1 = forceInN(-10);
        assertEquals(10, f1.inverse().newton(), 0);
        assertEquals(-10, f1.inverse().inverse().newton(), 0);
    }

    /**
     * Test of add method, of class ForceInN.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Force f0 = forceInN(10);
        Force f1 = forceInN(15.54);
        assertEquals(25.54, f0.add(f1).kgs2(), 0);
    }

    /**
     * Test of sub method, of class ForceInN.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Force f0 = forceInN(5.54);
        Force f1 = forceInN(0.54);
        assertEquals(5, f0.sub(f1).kgs2(), 0);
    }

    /**
     * Test of mul method, of class ForceInN.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        Force f0 = forceInN(5.54);
        Force f1 = forceInN(0.54);
        assertEquals(5, f0.sub(f1).kgs2(), 0);
    }

    /**
     * Test of div method, of class ForceInN.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Force f0 = forceInN(5);
        assertEquals(2.5, f0.div(2).newton(), 0);
        assertEquals(1, f0.div(f0), 0);
    }

    /**
     * Test of isZero method, of class ForceInN.
     */
    @Test
    public void testIsZero() {
        System.out.println("iszero");
        Force f0 = forceInN(0);
        Force f1 = forceInN(1);
        assertEquals(true, f0.isZero());
        assertEquals(false, f1.isZero());
    }

    /**
     * Test of compareTo method, of class ForceInN.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareto");
        Force f0 = forceInN(-15);
        Force f1 = forceInN(0);
        Force f2 = forceInN(12);
        assertEquals(0, f0.compareTo(f0));
        assertEquals(-1, f0.compareTo(f1));
        assertEquals(-1, f1.compareTo(f2));
    }

    /**
     * Test of hashCode method, of class ForceInN.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashcode");
        Force f0 = forceInN(1);
        Force f1 = forceInN(0);
        assertEquals(f0.hashCode(), f0.hashCode());
        assertNotSame(f0.hashCode(), f1.hashCode());
    }

    /**
     * Test of equals method, of class ForceInN.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Force f0 = forceInN(-15);
        Force f1 = forceInN(0);
        Force f2 = forceInN(12);
        assertEquals(true, f0.equals(f0));
        assertEquals(false, f0.equals(f1));
        assertEquals(false, f1.equals(f2));
    }
}