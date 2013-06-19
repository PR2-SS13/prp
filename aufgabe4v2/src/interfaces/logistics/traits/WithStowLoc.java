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
public interface WithStowLoc<S> extends Stowable {

    void setLocNull();

    void setLoc(S stowage, StowageLocation loc);
}
