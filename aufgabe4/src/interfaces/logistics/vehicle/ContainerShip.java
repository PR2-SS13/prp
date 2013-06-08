/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.traits.WithCargo;
import interfaces.logistics.Ship;

/**
 *
 * @author SaCry
 */
public interface ContainerShip extends Ship, WithCargo, ContainerStowage {
}
