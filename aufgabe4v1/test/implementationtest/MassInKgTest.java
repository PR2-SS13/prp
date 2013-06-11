/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.Values.*;

import interfaces.physics.Mass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class MassInKgTest {

    public MassInKgTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isZero method, of class MassInKg.
     */
    @Test
    public void testIsZero() {
        System.out.println("isZero");
        Mass m0 = massInKg(0.0);
        Mass m1 = massInKg(1.0);
        assertEquals(true, m0.isZero());
        assertEquals(false, m1.isZero());
    }

    /**
     * Test of add method, of class MassInKg.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Mass m0 = massInKg(0.0);
        Mass m1 = massInKg(1.0);
        assertEquals(1.0, m0.add(m1).kg(), 0);
    }

    @Test
    public void testSub() {
        System.out.println("sub");
        Mass m0 = massInKg(2.0);
        Mass m1 = massInKg(1.0);
        assertEquals(1.0, m0.sub(m1).kg(), 0);
    }

    /**
     * Test of mul method, of class MassInKg.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul");
        Mass m0 = massInKg(2.0);
        assertEquals(4.0, m0.mul(2.0).kg(), 0);
    }

    /**
     * Test of div method, of class MassInKg.
     */
    @Test
    public void testDiv_double() {
        System.out.println("div");
        Mass m0 = massInKg(8.0);
        assertEquals(4.0, m0.div(2.0).kg(), 0);
    }

    /**
     * Test of inverse method, of class MassInKg.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Mass m0 = massInKg(8.0);
        assertEquals(-8.0, m0.inverse().kg(), 0);
        assertEquals(8.0, m0.inverse().inverse().kg(), 0);
    }

    /**
     * Test of kg method, of class MassInKg.
     */
    @Test
    public void testKg() {
        System.out.println("kg");
        Mass m0 = massInKg(8.0);
        assertEquals(8.0, m0.kg(), 0);
        Mass m1 = massInKg(-8.0);
        assertEquals(-8.0, m1.kg(), 0);
    }

    /**
     * Test of ton method, of class MassInKg.
     */
    @Test
    public void testTon() {
        System.out.println("ton");
        Mass m0 = massInKg(500.0);
        assertEquals(0.5, m0.ton(), 0);
        Mass m1 = massInKg(-500.0);
        assertEquals(-0.5, m1.ton(), 0);
    }

    /**
     * Test of compareTo method, of class MassInKg.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Mass m0 = massInKg(-15);
        Mass m1 = massInKg(0);
        Mass m2 = massInKg(12);
        assertEquals(0, m0.compareTo(m0));
        assertEquals(-1, m0.compareTo(m1));
        assertEquals(-1, m1.compareTo(m2));
    }

    /**
     * Test of hashCode method, of class MassInKg.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Mass m0 = massInKg(1);
        Mass m1 = massInKg(0);
        assertEquals(m0.hashCode(), m0.hashCode());
        assertNotSame(m0.hashCode(), m1.hashCode());
    }

    /**
     * Test of equals method, of class MassInKg.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Mass m0 = massInKg(-12);
        Mass m1 = massInKg(0);
        Mass m2 = massInKg(12);
        Mass m3 = massInKg(12);
        assertEquals(true, m0.equals(m0));
        assertEquals(false, m0.equals(m1));
        assertEquals(false, m1.equals(m2));
        assertEquals(true, m3.equals(m2));
    }
}