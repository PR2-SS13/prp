/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.Acceleration;
import static implementation.Values.*;
import interfaces.Speed;
import interfaces.TimeDiff;

/**
 *
 * @author abl563
 */
public class AccelerationInMs2 extends AbstractScalar<Acceleration>
        implements Acceleration {

    private final double ms2; // met/sec^2

    private AccelerationInMs2(double ms2) {
        this.ms2 = ms2;
    }

    public static AccelerationInMs2 valueOf(double ms2) {
        return new AccelerationInMs2(ms2);
    }

    // tos, hc, eql, cmp
    @Override
    public String toString() {
        return String.format("AccelerationInMs2{ms2=%.2f}",
                this.ms2());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Acceleration)) {
            return false;
        }
        return this.compareTo((Acceleration) obj) == 0;
    }

    @Override
    public int hashCode() {
        return hashDouble(this.ms2());
    }

    @Override
    public int compareTo(Acceleration a) {
        return Double.compare(this.ms2(), a.ms2());
    }

    @Override
    public boolean isZero() {
        return (this.equals(ZERO_ACC));
    }

    @Override
    public boolean isValid() {
        return true;
    }

    // get, set, bools
    @Override
    public double ms2() {
        return this.ms2;
    }

    // Calculation
    @Override
    public Acceleration add(Acceleration value) {
        return Values.accelerationInMs2(this.ms2() + value.ms2());
    }

    @Override
    public Acceleration sub(Acceleration value) {
        return Values.accelerationInMs2(this.ms2() - value.ms2());
    }

    @Override
    public Acceleration mul(double factor) {
        return Values.accelerationInMs2(this.ms2() * factor);
    }

    @Override
    public Acceleration div(double factor) {
        return Values.accelerationInMs2(this.ms2() / factor);
    }

    @Override
    public Acceleration inverse() {
        return Values.accelerationInMs2(-this.ms2());
    }

    @Override
    public double div(Acceleration value) {
        return this.ms2() / value.ms2();
    }

    @Override
    public Speed mul(TimeDiff value) {
        return Values.speedInMs(this.ms2() * value.sec());
    }
}
