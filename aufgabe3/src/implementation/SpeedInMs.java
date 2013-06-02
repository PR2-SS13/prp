/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.Length;
import interfaces.Speed;
import interfaces.TimeDiff;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class SpeedInMs extends AbstractScalar<Speed> implements Speed {

    private double ms;

    private SpeedInMs(double ms) {
        this.ms = ms;
    }

    public static SpeedInMs valueOf(double ms) {
        return new SpeedInMs(ms);
    }

    @Override
    public Speed inverse() {
        return Values.speedInMs(-this.ms());
    }

    @Override
    public Speed add(Speed value) {
        return Values.speedInMs(this.ms() + value.ms());
    }

    @Override
    public Speed sub(Speed value) {
        return Values.speedInMs(this.ms() - value.ms());
    }

    @Override
    public Speed mul(double factor) {
        return Values.speedInMs(this.ms() * factor);
    }

    @Override
    public Speed div(double factor) {
        return Values.speedInMs(this.ms() / factor);
    }

    @Override
    public double div(Speed value) {
        return (this.ms() / value.ms());
    }

    @Override
    public Speed mul(Speed speed) {
        return Values.speedInMs(this.ms() * speed.ms());
    }

    @Override
    public Speed abs() {
        return Values.speedInMs(Math.abs(this.ms()));
    }

    @Override
    public Length mul(TimeDiff time) {
        return Values.lengthInM(this.ms() * time.sec());
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO_SPEED);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double kmh() {
        return this.ms / KMH_IN_MS;
    }

    @Override
    public double ms() {
        return this.ms;
    }

    @Override
    public int compareTo(Speed speed) {
        return Double.compare(this.ms(), speed.ms());
    }

    @Override
    public int hashCode() {
        return hashDouble(this.ms());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Speed)) {
            return false;
        }
        return this.compareTo((Speed) obj) == 0;
    }

    @Override
    public String toString() {
        return "SpeedInMs{ms: " + this.ms() + ", kmh:" + this.kmh() + "}";
    }
}
