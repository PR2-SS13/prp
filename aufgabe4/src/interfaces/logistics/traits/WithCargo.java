/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

import interfaces.physics.Mass;

/**
 *
 * @author SaCry
 */
public interface WithCargo {

    Mass emptyMass();

    Mass maxMass();

    boolean isEmpty();

    boolean isFull();
}
