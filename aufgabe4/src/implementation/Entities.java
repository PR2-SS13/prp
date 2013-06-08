/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.logistics.Entity;
import interfaces.logistics.ShipEngine;
import interfaces.logistics.vehicle.ContainerTruck;
import interfaces.physics.Speed;

/**
 *
 * @author SaCry
 */
public final class Entities implements Entity {
    
    
    
    public ContainerTruck containerTruck(ShipEngine engine, Speed maxSpeed){
        return new ContainerTruck();
    }
}
