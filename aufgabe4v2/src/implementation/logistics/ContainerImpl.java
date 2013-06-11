/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.UniqueId;
import interfaces.logistics.Container;
import static implementation.Values.*;

/**
 *
 * @author SaCry
 */
public class ContainerImpl extends AbstractContainer {

    private ContainerImpl(UniqueId id) {
        this.id = id;
        emptyMass = massInKg(100.0);
        maxMass = massInKg(10000.0);
        pStowage = palletStowage(1, 9, 3, maxMass().sub(emptyMass));
        //setLocNull();
    }

    public static Container valueOf(UniqueId id) {
        return new ContainerImpl(id);
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public boolean isFull() {
        return pStowage.isFull();
    }

    @Override
    public boolean isEmpty() {
        return pStowage.isEmpty();
    }
}
