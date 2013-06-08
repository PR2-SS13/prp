/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics;

import static implementation.Values.*;
import interfaces.logistics.BoundingBox;
import interfaces.physics.Length;
import interfaces.logistics.Name;
import interfaces.logistics.UniqueId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class logistic {

    public logistic() {
    }

    @Test
    public void testBoundingBox() {
        Length l1 = lengthInM(5.0);
        Length h1 = lengthInM(10.0);
        Length w1 = lengthInM(20.0);
        Length l2 = lengthInM(5.0);
        Length h2 = lengthInM(8.0);
        Length w2 = lengthInM(15.0);
        BoundingBox b1 = boundingBox(l1, h1, w1);
        BoundingBox b2 = boundingBox(l2, h2, w2);
        assertEquals(false, b1.fitsInto(b2));
        assertEquals(true, b2.fitsInto(b1));
        assertEquals(true, b2.fitsInto(b2));
    }

    @Test
    public void testName() {
        Name n = name("Queen Marry V");
        assertEquals(true, n.nameString().equals("Queen Marry V"));
        assertEquals(false, n.nameString().equals("Queen Marry"));
    }

    @Test
    public void testUniqueId() {
        UniqueId n = uniqueId(100);
        assertEquals(true, n.idNumber() == 100);
        assertEquals(false, n.idNumber() == 99);
    }

    @Test
    public void testContainerStowage() {
        UniqueId n = uniqueId(100);
        assertEquals(true, n.idNumber() == 100);
        assertEquals(false, n.idNumber() == 99);
        System.out.println("W000t");
    }
}