/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.vehicle;

import interfaces.logistics.traits.WithCargo;

/**
 *
 * @author SaCry
 *
 * Ein ADT für LKWs die einen Container transportieren können.
 *
 */
public interface ContainerTruck extends Vehicle, WithCargo, ContainerStowage {
}
