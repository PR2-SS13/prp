/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import static implementation.AbstractScalar.hashDouble;
import interfaces.Acceleration;
import interfaces.Force;
import interfaces.Mass;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class ForceInN extends AbstractScalar<Force> implements Force {

    private double newton;

    private ForceInN(double newton) {
        this.newton = newton;
    }

    public static ForceInN valueOf(double newton) {
        return new ForceInN(newton);
    }

    @Override
    public Force inverse() {
        return Values.forceInN(-this.newton());
    }

    @Override
    public Force add(Force value) {
        return Values.forceInN(this.newton() + value.newton());
    }

    @Override
    public Force sub(Force value) {
        return Values.forceInN(this.newton() - value.newton());
    }

    @Override
    public Force mul(double factor) {
        return Values.forceInN(this.newton() * factor);
    }

    @Override
    public Force div(double factor) {
        return Values.forceInN(this.newton() / factor);
    }

    @Override
    public double div(Force value) {
        return (this.newton() / value.newton());
    }

    @Override
    public Acceleration div(Mass value) {
        return Values.accelerationInMs2(this.newton() / value.kg());
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO_FORCE);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double newton() {
        return this.newton;
    }

    @Override
    public double kgs2() {
        return this.newton();
    }

    @Override
    public Force abs() {
        return Values.forceInN(Math.abs(this.newton()));
    }

    @Override
    public int compareTo(Force force) {
        return Double.compare(this.newton(), force.newton());
    }

    @Override
    public int hashCode() {
        return hashDouble(this.newton());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Force)) {
            return false;
        }
        return this.compareTo((Force) obj) == 0;
    }

    @Override
    public String toString() {
        return "ForceInN{" + this.newton() + '}';
    }
}
