/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author abl563
 */
public interface Force {

    public abstract double newton();

    public double kgsec2();

    public Force abs();

    public Acceleration div(Mass mass);
    
}
