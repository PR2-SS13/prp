/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.physics;

/**
 *
 * @author abl563
 */
public interface PhysicsScalar<T> extends PhysicsValue {

    T inverse();

    T add(T value);

    T sub(T value);

    T mul(double factor);

    T div(double factor);

    double div(T value);

    boolean isZero();

    boolean isValid();
}
