/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.Values.*;
import interfaces.Force;
import interfaces.Mass;
import interfaces.Power;
import interfaces.Speed;
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
public class PowerInWTest {

    public PowerInWTest() {
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
        Power p0 = powerInW(0.0);
        Power p1 = powerInW(1.0);
        assertEquals(true, p0.isZero());
        assertEquals(false, p1.isZero());
    }

    /**
     * Test of add method, of class MassInKg.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Power p0 = powerInW(0.0);
        Power p1 = powerInW(1.0);
        assertEquals(1.0, p0.add(p1).watt(), 0);
    }

    @Test
    public void testSub() {
        System.out.println("sub");
        Power p0 = powerInW(2.0);
        Power p1 = powerInW(1.0);
        assertEquals(1.0, p0.sub(p1).watt(), 0);
    }

    /**
     * Test of mul method, of class MassInKg.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul");
        Power p0 = powerInW(2.0);
        assertEquals(4.0, p0.mul(2.0).watt(), 0);
    }

    /**
     * Test of div method, of class MassInKg.
     */
    @Test
    public void testDiv_double() {
        System.out.println("div");
        Power p0 = powerInW(8.0);
        assertEquals(4.0, p0.div(2.0).watt(), 0);
    }

    /**
     * Test of inverse method, of class MassInKg.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Power p0 = powerInW(8.0);
        assertEquals(-8.0, p0.inverse().watt(), 0);
        assertEquals(8.0, p0.inverse().inverse().watt(), 0);
    }

    /**
     * Test of div method, of class PowerInW.
     */
    @Test
    public void testDiv_Power() {
        System.out.println("div");
        Power p0 = powerInW(8.0);
        Power p1 = powerInW(8.0);
        assertEquals(1.0, p0.div(p1), 0);
    }

    /**
     * Test of div method, of class PowerInW.
     */
    @Test
    public void testDiv_Speed() {
        System.out.println("div");
        Power p0 = powerInW(8.0);
        Speed s0 = speedInMs(8.0);
        assertEquals(1.0, p0.div(s0).newton(), 0);
    }

    /**
     * Test of watt method, of class PowerInW.
     */
    @Test
    public void testWatt() {
        System.out.println("watt");
        Power p0 = powerInW(8.0);
        assertEquals(8.0, p0.watt(), 0);
        Power p1 = powerInW(-8.0);
        assertEquals(-8.0, p1.watt(), 0);
    }

    /**
     * Test of kw method, of class PowerInW.
     */
    @Test
    public void testKw() {
        System.out.println("kw");
        Power p0 = powerInW(500.0);
        assertEquals(0.5, p0.kw(), 0);
        Power p1 = powerInW(-500.0);
        assertEquals(-0.5, p1.kw(), 0);
    }

    /**
     * Test of compareTo method, of class PowerInW.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Power p0 = powerInW(-15);
        Power p1 = powerInW(0);
        Power p2 = powerInW(12);
        assertEquals(0, p0.compareTo(p0));
        assertEquals(-1, p0.compareTo(p1));
        assertEquals(-1, p1.compareTo(p2));
    }

    /**
     * Test of hashCode method, of class PowerInW.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Power p0 = powerInW(1);
        Power p1 = powerInW(0);
        assertEquals(p0.hashCode(), p0.hashCode());
        assertNotSame(p0.hashCode(), p1.hashCode());
    }

    /**
     * Test of equals method, of class PowerInW.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Power p0 = powerInW(-12);
        Power p1 = powerInW(0);
        Power p2 = powerInW(12);
        Power p3 = powerInW(12);
        assertEquals(true, p0.equals(p0));
        assertEquals(false, p0.equals(p1));
        assertEquals(false, p1.equals(p2));
        assertEquals(true, p3.equals(p2));
    }
}