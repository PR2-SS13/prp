/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.physics;

import implementation.Values;
import interfaces.physics.Power;
import static implementation.Values.*;
import interfaces.physics.Force;
import interfaces.physics.Speed;

/**
 *
 * @author abl563
 */
public class PowerInW extends AbstractScalar<Power> implements Power {

    private double watt;

    private PowerInW(double watt) {
        this.watt = watt;
    }

    public static PowerInW valueOf(double watt) {
        return new PowerInW(watt);
    }

    @Override
    public Power inverse() {
        return Values.powerInW(-this.watt());
    }

    @Override
    public Power add(Power value) {
        return Values.powerInW(this.watt() + value.watt());
    }

    @Override
    public Power sub(Power value) {
        return Values.powerInW(this.watt() - value.watt());
    }

    @Override
    public Power mul(double factor) {
        return Values.powerInW(this.watt() * factor);
    }

    @Override
    public Power div(double factor) {
        return Values.powerInW(this.watt() / factor);
    }

    @Override
    public double div(Power value) {
        return (this.watt() / value.watt());
    }

    @Override
    public Force div(Speed value) {
        return Values.forceInN(this.watt() / value.ms());
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO_POWER);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double watt() {
        return this.watt;
    }

    @Override
    public double kw() {
        return this.watt() / KW_IN_WATT;
    }

    @Override
    public int compareTo(Power power) {
        return Double.compare(this.watt(), power.watt());
    }

    @Override
    public int hashCode() {
        return hashDouble(this.watt());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Power)) {
            return false;
        }
        return this.compareTo((Power) obj) == 0;
    }

    @Override
    public String toString() {
        return "PowerInW{watt: " + this.watt() + ", kilowatt:" + this.kw() + "}";
    }
}
