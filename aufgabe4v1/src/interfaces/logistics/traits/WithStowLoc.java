/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics.traits;

import interfaces.logistics.StowageLocation;

/**
 *
 * @author SaCry
 */
public interface WithStowLoc<S> {

    StowageLocation loc();

    void setLocNull();

    void setLoc(S stowage, StowageLocation loc);
}
