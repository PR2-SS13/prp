/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.Container;
import static implementation.Values.*;

/**
 *
 * @author SaCry
 */
public class NonContainer extends AbstractContainer {

    static Container singleton = new NonContainer();

    private NonContainer() {
        id = uniqueId(-2);
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
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return true;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
