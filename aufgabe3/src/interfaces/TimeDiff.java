/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface TimeDiff extends PhysicsScalar<TimeDiff>, Comparable<TimeDiff> {

    public double sec();

    public double hour();
}
