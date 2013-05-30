/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaces.Acceleration;
import static implementation.Values.*; 
import static com.google.common.base.Preconditions.*; 
import interfaces.Level;
import interfaces.Speed;
import interfaces.TimeDiff; 

/**
 *
 * @author abl563
 */
public class AccelerationInMs2 extends AbstractScalar<Acceleration> 
        implements Acceleration{
    
    private final double ms2; // met/sec^2
    
    private AccelerationInMs2(double ms2){
        this.ms2 = ms2;
    }
    
    // tos, hc, eql, cmp
    @Override
    public String toString() {
        return String.format("AccelerationInMs2{ms2=%.2f}",
                this.ms2());
    }
  
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Acceleration)) return false;
        return this.compareTo((Acceleration)obj) == 0;
    }
  
    @Override
    public int hashCode() {
        return hashDouble(this.ms2());
    }
  
    @Override
    public int compareTo(Acceleration a) {
        return Double.compare(this.ms2(), a.ms2());
    } 
    
    // get, set, bools
    @Override
    public double ms2(){
        return this.ms2;
    }

    @Override
    public boolean isZero() {
        return (this.equals(ZERO_ACCELERATION));
    }

    @Override
    public boolean isValid() {
        return true;
    }
    
    // Calculation
    @Override
    public Acceleration add(Acceleration value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceleration sub(Acceleration value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceleration mul(double factor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceleration div(double factor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceleration inverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double div(Acceleration value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Speed mul(TimeDiff value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceleration mul(Level value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
