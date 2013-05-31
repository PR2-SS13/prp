/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Power extends PhysicsScalar<Power>, Comparable<Power> {

    public double watt();

    public double kilowatt();
}
