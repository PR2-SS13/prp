/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Speed extends PhysicsScalar<Speed>, Comparable<Speed> {

    public double kmh();

    public double ms();

    public Speed mul(Speed speed);

    public Speed abs();

    public Length mul(TimeDiff time);
}
