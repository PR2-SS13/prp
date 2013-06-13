/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

/**
 *
 * @author SaCry
 */
public class StowageLocationImpl extends AbstractLocation {

    private StowageLocationImpl(int bay, int row, int tier) {
        this.bay = bay;
        this.row = row;
        this.tier = tier;
    }

    public static StowageLocationImpl valueOf(int bay, int row, int tier) {
        return new StowageLocationImpl(bay, row, tier);
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
