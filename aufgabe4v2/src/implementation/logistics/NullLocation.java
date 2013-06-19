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
public class NullLocation extends AbstractLocation {

    static StowageLocation singleton = new NullLocation();

    private NullLocation() {
    }

    public static StowageLocation singleton() {
        return singleton;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NullLocation)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return -1;
    }
}
