/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logistictest;

import static implementation.Values.*;
import implementation.logistics.Bounded3DimStackImpl;
import implementation.logistics.ContainerImpl;
import interfaces.logistics.Container;
import interfaces.logistics.Stowage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SaCry
 */
public class CompoundTest {

    public CompoundTest() {
    }

    @Test
    public void testCompound() {
        Container container = container(uniqueId(10));
        container.setLoc(palletStowage(1, 1, 1, ZERO_MASS), stowageLocation(1, 1, 1));
        Bounded3DimStackImpl<Container> stack = new Bounded3DimStackImpl<>(1, 1, 1, NULL_CONTAINER, null);
        assertEquals(true, stack.isEmpty());
        stack.load(container);
        assertEquals(true, stack.isFull());
        Bounded3DimStackImpl<Container> stack2 = new Bounded3DimStackImpl<>(1, 1, 2, NULL_CONTAINER, null);
        ArrayList<Container> al = new ArrayList<>();
        Container container1 = container(uniqueId(4));
        container1.setLoc(palletStowage(1, 1, 1, massInKg(10)), stowageLocation(1, 1, 1));
        al.add(container1);
        Container container2 = container(uniqueId(5));
        container2.setLoc(palletStowage(2, 2, 2, massInKg(10)), stowageLocation(1, 1, 2));
        al.add(container2);
        assertEquals(true, stack2.isEmpty());
        stack2.loadAll(al);
        assertEquals(true, stack2.isFull());
        Set<?> result = new HashSet<>(al);
        assertEquals(result, stack2.getAll());
        assertEquals(container1.hashCode(), stack2.get(stowageLocation(1, 1, 1)).hashCode());
    }
}