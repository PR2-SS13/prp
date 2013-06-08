/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.logistics;

import interfaces.logistics.BoundingBox;
import interfaces.physics.Length;

/**
 *
 * @author SaCry
 */
public class BoundingBoxImpl implements BoundingBox {

    Length length, width, height;

    private BoundingBoxImpl(Length length, Length width, Length height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public static BoundingBox valueOf(Length length, Length width, Length height) {
        return new BoundingBoxImpl(length, width, height);
    }

    @Override
    public Length length() {
        return this.length;
    }

    @Override
    public Length width() {
        return this.width;
    }

    @Override
    public Length height() {
        return this.height;
    }

    @Override
    public boolean fitsInto(BoundingBox boundingBox) {
        return (this.length().m() <= boundingBox.length().m()
                && this.width().m() <= boundingBox.width().m()
                && this.height().m() <= boundingBox.height().m());
    }
}
