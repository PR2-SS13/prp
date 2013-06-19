/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.BoundingBox;
import interfaces.logistics.Pallet;
import interfaces.logistics.Stowage;
import interfaces.logistics.StowageLocation;
import interfaces.logistics.UniqueId;
import interfaces.physics.Mass;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public abstract class AbstractPallet implements Pallet {

    UniqueId id;
    Mass mass;
    Mass emptyMass;
    BoundingBox bBox;
    StowageLocation loc;
    private Stowage stowage;

    @Override
    public Mass emptyMass() {
        return this.emptyMass;
    }

    @Override
    public UniqueId id() {
        return this.id;
    }

    @Override
    public StowageLocation loc() {
        return this.loc;
    }

    @Override
    public boolean isFull() {
        return stowage.isFull();
    }

    @Override
    public void setLocNull() {
        this.stowage = null;
        this.loc = NULL_LOCATION;
    }

    @Override
    public void setLoc(Object stowage, StowageLocation loc) {
        this.stowage = (Stowage) stowage;
        this.loc = loc;
    }

    @Override
    public Mass maxMass() {
        return this.mass;
    }

    @Override
    public void load(int bayNo, int rowNo, Object elem) {
        stowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Object elem) {
        stowage.load(elem);
    }

    @Override
    public void loadAll(Collection coll) {
        stowage.loadAll(coll);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return stowage.tierIsEmpty(bay, row);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return stowage.tierIsFull(bay, row);
    }

    @Override
    public boolean contains(Object elem) {
        return stowage.contains(elem);
    }

    @Override
    public boolean containsAll(Collection coll) {
        return stowage.containsAll(coll);
    }

    @Override
    public Object get(StowageLocation loc) {
        return (Pallet) stowage.get(loc);
    }

    @Override
    public Set getAll() {
        return stowage.getAll();
    }

    @Override
    public StowageLocation locationOf(Object elem) {
        return stowage.locationOf(elem);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pallet)) {
            return false;
        }
        if (this.compareTo((Pallet) obj) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Pallet t) {
        return this.id().compareTo(t.id());
    }

    @Override
    public int hashCode() {
        return id().hashCode();
    }

    @Override
    public boolean isEmpty() {
        return stowage.isEmpty();
    }
}
