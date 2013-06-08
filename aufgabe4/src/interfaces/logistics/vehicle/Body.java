/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.PhysObject;
import interfaces.logistics.traits.WithMass;
import interfaces.logistics.traits.WithBoundingBox;

/**
 *
 * @author SaCry
 */
public interface Body extends PhysObject, WithMass, WithBoundingBox {
}
