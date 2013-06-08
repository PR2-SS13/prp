/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.logistics.BoundingBox;
import interfaces.logistics.Entity;
import interfaces.logistics.vehicle.Container;
import interfaces.logistics.vehicle.ContainerShip;
import interfaces.logistics.vehicle.ContainerStowage;
import interfaces.logistics.vehicle.ShipEngine;
import interfaces.logistics.vehicle.ContainerTruck;
import interfaces.logistics.vehicle.Pallet;
import interfaces.logistics.vehicle.ShipHull;
import interfaces.logistics.vehicle.VanCarrier;
import interfaces.logistics.vehicle.XXXClassContainerShip;
import interfaces.physics.Power;
import interfaces.physics.Speed;

/**
 *
 * @author SaCry
 */
public final class Entities implements Entity {

    ContainerTruck containerTruck(ShipEngine engine, Speed maxSpeed) {
        return null;
    }

    VanCarrier vanCarrierTruck(ShipEngine engine, Speed maxSpeed) {
        return null;
    }

    ShipEngine shipEngine(BoundingBox boundingBox, Power maxPower) {
        return null;
    }

    ShipHull shipHull(BoundingBox boundingBox) {
        return null;
    }

    ContainerShip containerShip(ShipHull hull, ShipEngine engine, Speed maxSpeed, int bays, int rows, int tiers) {
        return null;
    }

    XXXClassContainerShip XXXTypeShip() {
        return null;
    }

    Container container() {
        return null;
    }

    Container nullContainer() {
        return null;
    }

    Container nonContainer() {
        return null;
    }

    ContainerStowage containerStowage(int bays, int rows, int tiers) {
        return null;
    }

    Pallet pallet() {
        return null;
    }

    Pallet nullPallet() {
        return null;
    }

    Pallet palletsStowage() {
        return null;
    }
}
