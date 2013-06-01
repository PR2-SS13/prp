/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Mass extends PhysicsScalar<Mass>, Comparable<Mass> {

    public double kg();

    public double ton();

    public Force mul(Acceleration acc);
}
