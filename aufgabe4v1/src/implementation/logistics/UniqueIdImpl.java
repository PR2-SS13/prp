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
}
