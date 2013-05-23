/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.Length;
import static implementation.Values.*;

/**
 *
 * @author abl563
 */
public class LengthInM extends AbstractScalar<Length> implements Length {
    
    private double meter;
    
    private LengthInM(double meter){
        this.meter = meter;
    }
    
    public static LengthInM valueOf(double meter){
        return new LengthInM(meter);
    }
    
    // tos, hc, eql, cmp
    @Override
    public String toString() {
        return String.format("LengthInM{kilometer=%.2f, meter=%.2f}",
                this.km(), this.m());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Length)) return false;
        return this.compareTo((Length)obj) == 0;
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
        return !(Double.isNaN(this.meter) || Double.isInfinite(this.meter));
    }

    @Override
    public Length add(Length value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Length sub(Length value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Length mul(double factor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Length div(double factor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Length inverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double div(Length value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double m() {
        return this.meter;
    }

    @Override
    public double km() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double circumference() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
