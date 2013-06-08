/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.physics;

import implementation.Values;
import interfaces.physics.Length;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class LengthInM extends AbstractScalar<Length> implements Length {

    private double m;

    private LengthInM(double m) {
        this.m = m;
    }

    public static LengthInM valueOf(double m) {
        return new LengthInM(m);
    }

    // tos, hc, eql, cmp
    @Override
    public String toString() {
        return String.format("LengthInM{kilometer=%.2f, meter=%.2f}",
                this.km(), this.m());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Length)) {
            return false;
        }
        return this.compareTo((Length) obj) == 0;
    }

    @Override
    public int hashCode() {
        return hashDouble(this.m());
    }

    @Override
    public int compareTo(Length o) {
        return Double.compare(this.m(), o.m());
    }

    @Override
    public boolean isZero() {
        return (this.equals(ZERO_LENGTH));
    }

    @Override
    public boolean isValid() {
        return !(Double.isNaN(this.m()) || Double.isInfinite(this.m()));
    }

    @Override
    public Length add(Length value) {
        return Values.lengthInM((this.m() + value.m()));
    }

    @Override
    public Length sub(Length value) {
        return Values.lengthInM((this.m() - value.m()));
    }

    @Override
    public Length mul(double factor) {
        return Values.lengthInM((this.m() * factor));
    }

    @Override
    public Length div(double factor) {
        return Values.lengthInM((this.m() / factor));
    }

    @Override
    public Length inverse() {
        return Values.lengthInM(-this.m());
    }

    @Override
    public double div(Length value) {
        return (this.m() / value.m());
    }

    @Override
    public double m() {
        return this.m;
    }

    @Override
    public double km() {
        return this.m() / KM_IN_METERS;
    }

    @Override
    public double ft() {
        return this.m() / FEET_IN_METERS;
    }
}
