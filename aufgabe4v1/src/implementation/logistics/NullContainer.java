/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.Container;

/**
 *
 * @author SaCry
 */
public class NullContainer extends AbstractContainer {

    static Container singleton = new NullContainer();

    private NullContainer() {
        id = uniqueId(-1);
        bBox = boundingBox(lengthInFt(20), lengthInFt(8), lengthInFt(8));
        pStowage = palletStowage(1, 9, 3, ZERO_MASS);
        emptyMass = massInKg(0.0);
        maxMass = massInKg(0.0);
        setLocNull();
    }

    public static Container singleton() {
        return singleton;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean isFree() {
        return true;
    }
}
