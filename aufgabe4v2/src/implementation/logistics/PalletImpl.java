/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.Pallet;
import interfaces.logistics.UniqueId;
import interfaces.physics.Mass;
import static implementation.Values.*;

/**
 *
 * @author SaCry
 */
public class PalletImpl extends AbstractPallet {

    private PalletImpl(UniqueId id, Mass mass) {
        this.id = id;
        this.mass = mass;
        this.bBox = boundingBox(lengthInM(3.0), lengthInM(0.7), lengthInM(1.0));
        //setLocNull();
    }

    public static Pallet valueOf(UniqueId id, Mass mass) {
        return new PalletImpl(id, mass);
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }
}
