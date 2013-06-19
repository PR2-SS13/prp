/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.BoundingBox;
import interfaces.logistics.Container;
import interfaces.logistics.ContainerStowage;
import interfaces.logistics.Stowage;
import interfaces.logistics.StowageLocation;
import interfaces.physics.Mass;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public class ContainerStowageImpl implements ContainerStowage {

    Bounded3DimStackImpl<Container> contents;
    public static Container nullContent = NULL_CONTAINER;
    private BoundingBox bBox;
    private Mass emptyMass, maxMass;

    private ContainerStowageImpl(int bays, int rows, int tiers, Mass maxMass) {
        this.bBox = boundingBox(lengthInFt(20).mul(bays), lengthInFt(8).mul(rows), lengthInFt(8).mul(tiers));
        this.contents = new Bounded3DimStackImpl<>(bays, rows, tiers, nullContent, this);
        this.emptyMass = massInKg(0.0);
        this.maxMass = maxMass;
    }

    public static Stowage valueOf(int bays, int rows, int tiers, Mass maxMass) {
        return new ContainerStowageImpl(bays, rows, tiers, maxMass);
    }

    @Override
    public void load(int bayNo, int rowNo, Container elem) {
        contents.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Container elem) {
        contents.load(elem);
    }

    @Override
    public void loadAll(Collection<Container> coll) {
        contents.loadAll(coll);
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        return contents.containsAll(coll);
    }

    @Override
    public Container get(StowageLocation loc) {
        return (Container) contents.get(loc);
    }

    @Override
    public Set<Container> getAll() {
        return contents.getAll();
    }

    @Override
    public StowageLocation locationOf(Container elem) {
        return contents.locationOf(elem);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return contents.tierIsEmpty(bay, row);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return contents.tierIsFull(bay, row);
    }

    @Override
    public boolean contains(Object elem) {

        if (!(elem instanceof Container)) {
            return false;
        }
        return contents.contains(elem);

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
}
