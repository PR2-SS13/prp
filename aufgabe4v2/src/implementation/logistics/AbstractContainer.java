/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.BoundingBox;
import interfaces.logistics.Container;
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
public abstract class AbstractContainer implements Container {

    UniqueId id;
    Stowage pStowage;
    BoundingBox bBox;
    Mass maxMass;
    Mass emptyMass;
    private Stowage stowage;
    private StowageLocation loc;

    @Override
    public UniqueId id() {
        return this.id;
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
    public void load(int bayNo, int rowNo, Pallet elem) {
        pStowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Pallet elem) {
        pStowage.load(elem);
    }

    @Override
    public void loadAll(Collection<Pallet> coll) {
        pStowage.loadAll(coll);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return pStowage.tierIsEmpty(bay, row);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return pStowage.tierIsFull(bay, row);
    }

    @Override
    public boolean contains(Object elem) {
        return pStowage.contains(elem);
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        return pStowage.containsAll(coll);
    }

    @Override
    public Pallet get(StowageLocation loc) {
        return (Pallet) pStowage.get(loc);
    }

    @Override
    public Set<Pallet> getAll() {
        return pStowage.getAll();
    }

    @Override
    public StowageLocation locationOf(Pallet elem) {
        return pStowage.locationOf(elem);
    }

    @Override
    public void setLocNull() {
        this.stowage = null;
    }

    @Override
    public void setLoc(Object stowage, StowageLocation loc) {
        this.stowage = (Stowage) stowage;
        this.loc = loc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Container)) {
            return false;
        }
        if (this.compareTo((Container) obj) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Container t) {
        return this.id().compareTo(t.id());
    }

    @Override
    public int hashCode() {
        return id().hashCode();
    }

    @Override
    public StowageLocation loc() {
        return this.loc;
    }
}
