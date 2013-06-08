/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

import interfaces.physics.Power;

/**
 *
 * @author SaCry
 */
public interface WithPower {

    Power power();

    Power maxPower();

    void setLevel(double level);
}
