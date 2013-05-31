/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Length extends PhysicsScalar<Length>, Comparable<Length> {
    
    public abstract double meter();
    
    public abstract double kmeter();
    
    public abstract double feet();
    
}
