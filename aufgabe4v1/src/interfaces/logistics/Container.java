/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

import interfaces.logistics.Stowage;
import interfaces.logistics.traits.WithForm;
import interfaces.logistics.traits.WithStowLoc;

/**
 *
 * @author SaCry
 *
 * Ein konkretisierter ADT für Container, die 3d-Stapel von Paletten enthalten
 * Die Container wissen in welchem Stauraum sie wo stehen.
 *
 */
public interface Container extends Stowage<Pallet>,
        WithStowLoc, WithForm, Comparable<Container> {
}
