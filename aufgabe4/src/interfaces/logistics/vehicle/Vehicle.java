/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.traits.WithPower;
import interfaces.logistics.traits.WithUniqueId;
import interfaces.logistics.traits.WithPosition;
import interfaces.logistics.traits.WithPropulsion;
import interfaces.Mutable;

/**
 *
 * @author SaCry
 *
 * ein Körper änderbares physikalisches Objekt mit diversen weiteren
 * Eigenschaften.
 *
 */
public interface Vehicle extends Mutable, Body, WithUniqueId<Vehicle>,
        WithPosition, WithPower, WithPropulsion, Comparable<Vehicle> {
}
