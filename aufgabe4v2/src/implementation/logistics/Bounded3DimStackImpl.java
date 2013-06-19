/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import static implementation.Values.*;
import interfaces.logistics.Bounded3DimStack;
import interfaces.logistics.Stowage;
import interfaces.logistics.StowageLocation;
import interfaces.logistics.traits.Stowable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public class Bounded3DimStackImpl<E extends Stowable> implements Bounded3DimStack<E> {

    Map<StowageLocation, E> contents = new HashMap<>();
    int numberOfBays, numberOfRows, numberOfTiers;
    Stowage nullObj;
    Stowage parent;

    public Bounded3DimStackImpl(int bays, int rows, int tiers, Object nullObj, Stowage parent) {
        this.numberOfBays = bays;
        this.numberOfRows = rows;
        this.numberOfTiers = tiers;
        this.nullObj = (Stowage) nullObj;
        this.parent = parent;
    }

    public int bays() {
        return numberOfBays;
    }

    public int rows() {
        return numberOfRows;
    }

    public int tiers() {
        return numberOfTiers;
    }

    @Override
    public void load(E elem) {
        contents.put(elem.loc(), elem);
        elem.setLoc(parent, elem.loc());
    }

    @Override
    public void loadAll(Collection<E> coll) {
        for (E e : coll) {
            this.load(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    @Override
    public boolean isFull() {
        return (contents.size() >= (numberOfTiers * numberOfRows * numberOfBays));
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        StowageLocation l;
        for (int z = 0; z < numberOfTiers; z++) {
            l = stowageLocation(bay, row, z);
            if (!this.get(l).equals(this.nullObj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        StowageLocation l;
        for (int z = 0; z < numberOfTiers; z++) {
            l = stowageLocation(bay, row, z);
            if (this.get(l).equals(this.nullObj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object elem) {
        for (Map.Entry<StowageLocation, E> entry : contents.entrySet()) {

            if (entry.getValue().equals(elem)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        for (Iterator i = coll.iterator(); i.hasNext();) {
            E e = (E) i.next();
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(StowageLocation loc) {
        for (Map.Entry<StowageLocation, E> entry : contents.entrySet()) {
            if (entry.getKey().equals(loc)) {
                return entry.getValue();
            }
        }
        return (E) this.nullObj;
    }

    @Override
    public Set<E> getAll() {
        Set<E> result = new HashSet<>();
        for (Map.Entry<StowageLocation, E> entry : contents.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public StowageLocation locationOf(E elem) {
        for (Map.Entry<StowageLocation, E> entry : contents.entrySet()) {
            if (entry.getValue().equals(elem)) {
                return entry.getKey();
            }
        }
        return NULL_LOCATION;
    }

    @Override
    public void load(int bayNo, int rowNo, E elem) {
        if (this.tierIsFull(bayNo, rowNo)) {
            throw new RuntimeException("Stack full!");
        }
        StowageLocation l;
        for (int z = 0; z < numberOfTiers; z++) {
            l = stowageLocation(bayNo, rowNo, z);
            if (this.get(l).equals(this.nullObj)) {
                this.load(elem);
                return;
            }
        }
    }
}
