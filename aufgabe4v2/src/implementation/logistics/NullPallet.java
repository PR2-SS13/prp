/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.Pallet;

/**
 *
 * @author SaCry
 */
public class NullPallet extends AbstractPallet {

    static private Pallet singleton = new NullPallet();

    private NullPallet() {
        this.id = uniqueId(0);
        this.bBox = boundingBox(lengthInM(3.0), lengthInM(0.7), lengthInM(1.0));
        this.mass = ZERO_MASS;
        setLocNull();
    }

    public static Pallet singleton() {
        return singleton;
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }
}
