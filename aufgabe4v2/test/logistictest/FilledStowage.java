/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logistictest;

import static implementation.Values.*;
import interfaces.logistics.Container;
import interfaces.logistics.UniqueId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class FilledStowage {

    public FilledStowage() {
    }



    @Test
    public void testContainer() {
        UniqueId id = uniqueId(1000);
        Container c1 = container(id);
        assertEquals(false, c1.isBlocked());
        assertEquals(false, c1.isFree());
        assertEquals(true, c1.isOccupied());
        assertEquals(false, c1.isEmpty());
        assertEquals(false, c1.isFull()); 
    }
}