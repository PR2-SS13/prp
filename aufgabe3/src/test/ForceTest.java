/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.Test;
import static org.junit.Assert.*;
import static implementation.Values.*;
import interfaces.Force;

/**
 *
 * @author SaCry
 */
public class ForceTest {

    private double delta = 0.000001;

    public ForceTest() {
    }

    @Test
    public void testNewton() {
        Force f0 = forceInN(10);     // 10n
        assertEquals(10, f0.newton(), 0);        // 10n

        Force f1 = forceInN(-10);     // 10n
        assertEquals(-10, f1.newton(), 0);        // 10n
    }
}
