/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.Acceleration;
import interfaces.Force;
import interfaces.Mass;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class MassInKg extends AbstractScalar<Mass> implements Mass {

    private double kg;

    private MassInKg(double kg) {
        this.kg = kg;
    }

    public static Mass valueOf(double kg) {
        return new MassInKg(kg);
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO_MASS);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Mass add(Mass value) {
        return Values.massInKg(this.kg() + value.kg());
    }

    @Override
    public Mass sub(Mass value) {
        return Values.massInKg(this.kg() - value.kg());
    }

    @Override
    public Mass mul(double factor) {
        return Values.massInKg(this.kg() * factor);
    }

    @Override
    public Mass div(double factor) {
        return Values.massInKg(this.kg() / factor);
    }

    @Override
    public Mass inverse() {
        return Values.massInKg(-this.kg());
    }

    @Override
    public double div(Mass value) {
        return (this.kg() / value.kg());
    }

    @Override
    public double kg() {
        return this.kg;
    }

    @Override
    public double ton() {
        return this.kg / TONS_IN_KG;
    }

    @Override
    public Force mul(Acceleration value) {
        return Values.forceInN(this.kg() * value.ms2());
    }

    @Override
    public int compareTo(Mass value) {
        return Double.compare(this.kg(), value.kg());
    }

    @Override
    public int hashCode() {
        return hashDouble(this.kg());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Mass)) {
            return false;
        }
        return this.compareTo((Mass) obj) == 0;
    }

    @Override
    public String toString() {
        return "MassInKg{kg: " + this.kg() + ", ton:" + this.ton() + "}";
    }
}
