/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.physics;

/**
 *
 * @author abl563
 */
public interface Power extends PhysicsScalar<Power>, Comparable<Power> {

    public double watt();

    public double kw();

    public Force div(Speed speed);
}
