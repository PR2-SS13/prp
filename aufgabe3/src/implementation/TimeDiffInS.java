/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.TimeDiff;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class TimeDiffInS extends AbstractScalar<TimeDiff> implements TimeDiff {

    private double sec;

    private TimeDiffInS(double sec) {
        this.sec = sec;
    }

    public static TimeDiffInS valueOf(double sec) {
        return new TimeDiffInS(sec);
    }

    @Override
    public TimeDiff inverse() {
        return Values.timeDiffInS(-this.sec());
    }

    @Override
    public TimeDiff add(TimeDiff value) {
        return Values.timeDiffInS(this.sec() + value.sec());
    }

    @Override
    public TimeDiff sub(TimeDiff value) {
        return Values.timeDiffInS(this.sec() - value.sec());
    }

    @Override
    public TimeDiff mul(double factor) {
        return Values.timeDiffInS(this.sec() * factor);
    }

    @Override
    public TimeDiff div(double factor) {
        return Values.timeDiffInS(this.sec() / factor);
    }

    @Override
    public double div(TimeDiff value) {
        return (this.sec() / value.sec());
    }

    @Override
    public boolean isZero() {
        return this.equals(ZERO_TIMEDIFF);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double sec() {
        return this.sec;
    }

    @Override
    public double hour() {
        return this.sec() / H_IN_SECS;
    }

    @Override
    public int compareTo(TimeDiff value) {
        return Double.compare(this.sec(), value.sec());
    }

    @Override
    public int hashCode() {
        return hashDouble(this.sec());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeDiff)) {
            return false;
        }
        return this.compareTo((TimeDiff) obj) == 0;
    }

    @Override
    public String toString() {
        return "TimeDiffInS{" + this.sec() + '}';
    }
}
