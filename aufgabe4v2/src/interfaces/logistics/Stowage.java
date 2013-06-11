/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

import interfaces.logistics.traits.WithCargo;
import interfaces.Mutable;

/**
 *
 * @author SaCry
 */
public interface Stowage<E> extends Mutable, WithCargo, Bounded3DimStack<E> {
}
