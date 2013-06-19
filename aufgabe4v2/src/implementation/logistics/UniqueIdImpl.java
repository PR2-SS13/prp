/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.UniqueId;

/**
 *
 * @author SaCry
 */
public class UniqueIdImpl implements UniqueId {

    private long id;

    private UniqueIdImpl(long id) {
        this.id = id;
    }

    public static UniqueIdImpl valueOf(long id) {
        return new UniqueIdImpl(id);
    }

    @Override
    public long idNumber() {
        return this.id;
    }

    @Override
    public int compareTo(UniqueId t) {
        return Long.compare(this.idNumber(), t.idNumber());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UniqueIdImpl)) {
            return false;
        }
        if (this.compareTo((UniqueIdImpl) obj) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
}
