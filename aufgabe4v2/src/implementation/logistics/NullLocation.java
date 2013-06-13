/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

/**
 *
 * @author sacry
 */
public class NullLocation extends AbstractLocation {

    private NullLocation(int bay, int row, int tier) {
        this.bay = bay;
        this.row = row;
        this.tier = tier;
    }

    public static NullLocation valueOf(int bay, int row, int tier) {
        return new NullLocation(bay, row, tier);
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
