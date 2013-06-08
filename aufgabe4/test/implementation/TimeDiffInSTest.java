/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.Values.*;

import interfaces.physics.TimeDiff;
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
public class TimeDiffInSTest {

    public TimeDiffInSTest() {
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
     * Test of add method, of class TimeDiffInS.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        TimeDiff t0 = timeDiffInS(0.0);
        TimeDiff t1 = timeDiffInS(1.0);
        assertEquals(1.0, t0.add(t1).sec(), 0);
    }

    /**
     * Test of sub method, of class TimeDiffInS.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        TimeDiff t0 = timeDiffInS(2.0);
        TimeDiff t1 = timeDiffInS(1.0);
        assertEquals(1.0, t0.sub(t1).sec(), 0);
    }

    /**
     * Test of mul method, of class TimeDiffInS.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        TimeDiff t0 = timeDiffInS(2.0);
        assertEquals(4.0, t0.mul(2.0).sec(), 0);
    }

    /**
     * Test of div method, of class TimeDiffInS.
     */
    @Test
    public void testDiv_double() {
        System.out.println("div");
        TimeDiff t0 = timeDiffInS(4.0);
        assertEquals(2.0, t0.div(2.0).sec(), 0);
    }

    /**
     * Test of div method, of class TimeDiffInS.
     */
    @Test
    public void testDiv_TimeDiff() {
        System.out.println("div");
        TimeDiff t0 = timeDiffInS(2.0);
        TimeDiff t1 = timeDiffInS(2.0);
        assertEquals(1.0, t0.div(t1), 0);
    }

    /**
     * Test of isZero method, of class TimeDiffInS.
     */
    @Test
    public void testIsZero() {
        System.out.println("isZero");
        TimeDiff t0 = timeDiffInS(0.0);
        TimeDiff t1 = timeDiffInS(1.0);
        assertEquals(true, t0.isZero());
        assertEquals(false, t1.isZero());
    }

    /**
     * Test of inverse method, of class TimeDiffInS.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        TimeDiff t1 = timeDiffInS(8.0);
        assertEquals(-8.0, t1.inverse().sec(), 0);
        assertEquals(8.0, t1.inverse().inverse().sec(), 0);
    }

    /**
     * Test of sec method, of class TimeDiffInS.
     */
    @Test
    public void testSec() {
        System.out.println("sec");
        TimeDiff t0 = timeDiffInS(8.0);
        assertEquals(8.0, t0.sec(), 0);
        TimeDiff t1 = timeDiffInS(-8.0);
        assertEquals(-8.0, t1.sec(), 0);
    }

    /**
     * Test of hour method, of class TimeDiffInS.
     */
    @Test
    public void testHour() {
        System.out.println("hour");
        TimeDiff t0 = timeDiffInS(3600.0);
        assertEquals(1.0, t0.hour(), 0);
        TimeDiff t1 = timeDiffInS(-3600.0);
        assertEquals(-1.0, t1.hour(), 0);
    }

    /**
     * Test of compareTo method, of class TimeDiffInS.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        TimeDiff t0 = timeDiffInS(-15);
        TimeDiff t1 = timeDiffInS(0);
        TimeDiff t2 = timeDiffInS(12);
        assertEquals(0, t0.compareTo(t0));
        assertEquals(-1, t0.compareTo(t1));
        assertEquals(-1, t1.compareTo(t2));
    }

    /**
     * Test of hashCode method, of class TimeDiffInS.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TimeDiff t0 = timeDiffInS(1);
        TimeDiff t1 = timeDiffInS(0);
        assertEquals(t0.hashCode(), t0.hashCode());
        assertNotSame(t0.hashCode(), t1.hashCode());
    }

    /**
     * Test of equals method, of class TimeDiffInS.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        TimeDiff t0 = timeDiffInS(-12);
        TimeDiff t1 = timeDiffInS(0);
        TimeDiff t2 = timeDiffInS(12);
        TimeDiff t3 = timeDiffInS(12);
        assertEquals(true, t0.equals(t0));
        assertEquals(false, t0.equals(t1));
        assertEquals(false, t1.equals(t2));
        assertEquals(true, t3.equals(t2));
    }
}