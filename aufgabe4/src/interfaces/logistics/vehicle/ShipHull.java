/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.vehicle.Body;
import interfaces.logistics.traits.WithUniqueId;
import interfaces.Immutable;

/**
 *
 * @author SaCry
 */
public interface ShipHull extends Immutable, Body,
        WithUniqueId<ShipHull>, Comparable<ShipHull> {
}
