/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

import interfaces.Mutable;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author SaCry
 */
public interface Bounded3DimStack<E> extends Mutable {

    void load(int bayNo, int rowNo, E elem);

    void load(E elem);

    void loadAll(Collection<E> coll);

    boolean isEmpty();

    boolean isFull();

    boolean tierIsEmpty(int bay, int row);

    boolean tierIsFull(int bay, int row);

    boolean contains(Object elem);

    boolean containsAll(Collection<?> coll);

    E get(StowageLocation loc);

    Set<E> getAll();

    StowageLocation locationOf(E elem);

    int bays();

    int rows();

    int tiers();
}
