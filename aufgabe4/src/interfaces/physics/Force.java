/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.physics;

/**
 *
 * @author abl563
 */
public interface Force extends PhysicsScalar<Force>, Comparable<Force> {

    public abstract double newton();

    public double kgs2();

    public Force abs();

    public Acceleration div(Mass mass);
}
