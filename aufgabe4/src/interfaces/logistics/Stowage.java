/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

import interfaces.logistics.vehicle.Body;
import interfaces.logistics.traits.WithCargo;

/**
 *
 * @author SaCry
 */
public interface Stowage<E> extends Body, WithCargo, Bounded3DimStack<E> {
}
