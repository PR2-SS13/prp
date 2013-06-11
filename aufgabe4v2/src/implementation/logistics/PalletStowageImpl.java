/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.BoundingBox;
import interfaces.logistics.Stowage;
import interfaces.logistics.Pallet;
import interfaces.logistics.StowageLocation;
import interfaces.physics.Mass;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public class PalletStowageImpl implements Stowage<Pallet> {

    Bounded3DimStackImpl<Pallet> contents;
    public static Pallet nullContent = NULL_PALLET;
    private BoundingBox bBox;
    private Mass emptyMass, maxMass;

    private PalletStowageImpl(int bays, int rows, int tiers, Mass maxMass) {
        this.bBox = boundingBox(lengthInFt(20), lengthInFt(8), lengthInFt(8));
        this.contents = new Bounded3DimStackImpl<>(bays, rows, tiers, nullContent, this);
        this.emptyMass = massInKg(0.0);
        this.maxMass = maxMass;
    }

    public static PalletStowageImpl valueOf(int bays, int rows, int tiers, Mass maxMass) {
        return new PalletStowageImpl(bays, rows, tiers, maxMass);
    }

    @Override
    public Mass emptyMass() {
        return this.emptyMass;
    }

    @Override
    public Mass maxMass() {
        return this.maxMass;
    }

    @Override
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    @Override
    public boolean isFull() {
        return contents.isFull();
    }

    @Override
    public void load(int bayNo, int rowNo, Pallet elem) {
        contents.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Pallet elem) {
        contents.load(elem);
    }

    @Override
    public void loadAll(Collection<Pallet> coll) {
        contents.loadAll(coll);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return contents.tierIsEmpty(bay, row);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pallet get(StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Pallet> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StowageLocation locationOf(Pallet elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
