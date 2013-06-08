/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.PhysObject;
import interfaces.logistics.traits.WithMass;
import interfaces.logistics.traits.WithPosition;
import interfaces.logistics.traits.WithSpeed;
import interfaces.Mutable;

/**
 *
 * @author SaCry
 */
public interface Particle extends Mutable, PhysObject,
        WithPosition, WithMass, WithSpeed {
}
