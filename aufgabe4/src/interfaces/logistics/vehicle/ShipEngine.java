/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.vehicle.Body;
import interfaces.logistics.traits.WithPower;
import interfaces.logistics.traits.WithUniqueId;
import interfaces.Mutable;

/**
 *
 * @author SaCry
 */
public interface ShipEngine extends Mutable, Body, WithPower,
        WithUniqueId<ShipEngine>, Comparable<ShipEngine> {
}
