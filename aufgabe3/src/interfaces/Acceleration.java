/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Acceleration extends PhysicsScalar<Acceleration>, 
        Comparable <Acceleration> {
    
    public abstract double ms2();
    
    Speed mul(TimeDiff value);
    
    Acceleration mul(Level value);
    
}
