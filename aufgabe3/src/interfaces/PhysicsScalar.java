/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface PhysicsScalar<T> extends PhysicsValue<T> {
    
    boolean isZero();
    
    boolean isValid();
    
    T add(T value);
    
    T sub(T value);
    
    T mul(double factor);
    
    T div(double factor);
    
    T inverse();
    
    double div(T value);
    
}


