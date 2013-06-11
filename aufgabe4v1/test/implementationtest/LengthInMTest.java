/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.Values.*;

import interfaces.physics.Length;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class LengthInMTest {

    private double delta = 0.000001;

    public LengthInMTest() {
    }

    @Test
    public void testUnits() {
        System.out.println("units");
        Length l0 = lengthInM(1);         // 1m
        assertEquals(3.28084, l0.ft(), delta);   // 3.2808399ft
        Length l1 = lengthInM(1);         // 1m
        assertEquals(1, l1.m(), 0);              // 1m
        Length l2 = lengthInFt(1);        // 1ft
        assertEquals(0.3048, l2.m(), delta);     // 0,3048m
        Length l3 = lengthInM(1000);      // 1000m
        assertEquals(1, l3.km(), 0);             // 1km
        Length l4 = lengthInM(2250);      // 2250m
        assertEquals(2.25, l4.km(), 0);          // 2.25km
        Length l5 = lengthInKm(2);        // 2km
        assertEquals(2000, l5.m(), 0);           // 2000
    }

    /**
     * Test of inverse method, of class LengthInM.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Length l0 = lengthInM(1);            // 1m
        assertEquals(-1, l0.inverse().m(), 0);      // -1m
        Length l1 = lengthInM(3.2808399);        // 3.2808399
        assertEquals(-3.2808399, l1.inverse().m(), 0);  // -3.2808399
        assertEquals(3.2808399, l1.inverse().inverse().m(), 0); // 3.2808399 (doppel inverse)
    }

    /**
     * Test of add method, of class LengthInM.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        // 10m + 1km = 1010m
        Length l0 = lengthInM(10);
        Length l1 = lengthInKm(1);
        assertEquals(1010, l0.add(l1).m(), 0);
        // 10m + 1ft = 1010m
        Length l2 = lengthInM(10);
        Length l3 = lengthInFt(1);
        assertEquals(10.3048, l2.add(l3).m(), delta);
    }

    /**
     * Test of sub method, of class LengthInM.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        // 12km - 2km = 10000m
        Length l0 = lengthInKm(12);
        Length l1 = lengthInKm(2);
        assertEquals(10000, l0.sub(l1).m(), 0);
        // 10.3048m - 1ft = 1010m
        Length l2 = lengthInM(10.3048);
        Length l3 = lengthInFt(1);
        assertEquals(10, l2.sub(l3).m(), delta);
        // 10.3048m - 0km = 1010m
        Length l4 = lengthInM(10.3048);
        Length l5 = lengthInKm(0);
        assertEquals(10.3048, l4.sub(l5).m(), delta);
    }

    /**
     * Test of mul method, of class LengthInM.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        // 2km * 2 = 4km
        Length l0 = lengthInKm(2);
        assertEquals(4, l0.mul(2).km(), 0);
    }

    /**
     * Test of div method, of class LengthInM.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        // 2km / 2 = 1km
        Length l0 = lengthInKm(2);
        assertEquals(1, l0.div(2).km(), 0);
        Length l1 = lengthInM(10);
        Length l2 = lengthInM(5);
        assertEquals(2, l1.div(l2), 0);
    }

    /**
     * Test of isZero method, of class LengthInM.
     */
    @Test
    public void testIsZero() {
        System.out.println("iszero");
        Length l0 = lengthInKm(0);
        assertEquals(true, l0.isZero());
        Length l1 = lengthInKm(1);
        assertEquals(false, l1.isZero());

    }

    /**
     * Test of compareTo method, of class LengthInM.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareto");
        Length l0 = lengthInKm(-15);
        Length l1 = lengthInKm(0);
        Length l2 = lengthInKm(12);
        assertEquals(0, l0.compareTo(l0));
        assertEquals(-1, l0.compareTo(l1));
        assertEquals(-1, l1.compareTo(l2));
    }

    /**
     * Test of hashCode method, of class LengthInM.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashcode");
        Length l0 = lengthInKm(0);
        Length l1 = lengthInKm(1);
        assertEquals(l0.hashCode(), l0.hashCode());
        assertNotSame(l0.hashCode(), l1.hashCode());

    }

    /**
     * Test of equals method, of class LengthInM.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Length l0 = lengthInKm(-15);
        Length l1 = lengthInKm(0);
        Length l2 = lengthInKm(12);
        assertEquals(true, l0.equals(l0));
        assertEquals(false, l0.equals(l1));
        assertEquals(false, l1.equals(55));

    }
}