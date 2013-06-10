/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.traits.WithStowLoc;
import interfaces.logistics.Bounded3DimStack;
import interfaces.logistics.Stowage;
import interfaces.logistics.StowageLocation;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public class Bounded3DimStackImpl<E extends WithStowLoc> implements Bounded3DimStack<E> {

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

    @Override
    public int bays() {
        return numberOfBays;
    }

    @Override
    public int rows() {
        return numberOfRows;
    }

    @Override
    public int tiers() {
        return numberOfTiers;
    }

    @Override
    public void load(int bayNo, int rowNo, E elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(E elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAll(Collection<E> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public E get(StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<E> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StowageLocation locationOf(E elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
