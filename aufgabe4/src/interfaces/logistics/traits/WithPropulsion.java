/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

import interfaces.physics.TimeDiff;

/**
 *
 * @author SaCry
 */
public interface WithPropulsion extends WithPower {

    void moveStep(TimeDiff deltaTime);
}
