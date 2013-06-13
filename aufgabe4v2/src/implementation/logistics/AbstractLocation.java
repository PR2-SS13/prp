/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.StowageLocation;

/**
 *
 * @author sacry
 */
public abstract class AbstractLocation implements StowageLocation {

    int bay;
    int row;
    int tier;

    @Override
    public int row() {
        return this.row;
    }

    @Override
    public int tier() {
        return this.tier;
    }

    @Override
    public int bay() {
        return this.bay;
    }


}
