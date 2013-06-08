/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.vehicle.Vehicle;
import interfaces.logistics.traits.WithCargo;
import interfaces.logistics.vehicle.ContainerStowage;

/**
 *
 * @author SaCry
 *
 * Ein ADT für die Hubfahrzeuge, die Container in den Terminals transportieren
 * und stapeln.
 *
 */
public interface VanCarrier extends Vehicle, WithCargo, ContainerStowage {
}
