/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.StowageLocation;

/**
 *
 * @author SaCry
 */
public class StowageLocationImpl implements StowageLocation {

    int bay;
    int row;
    int tier;

    private StowageLocationImpl(int bay, int row, int tier) {
        this.bay = bay;
        this.row = row;
        this.tier = tier;
    }

    public static StowageLocationImpl valueOf(int bay, int row, int tier) {
        return new StowageLocationImpl(bay, row, tier);
    }


    @Override
    public int row() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int bay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
