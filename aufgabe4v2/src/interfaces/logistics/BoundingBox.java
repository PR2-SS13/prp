/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.logistics;

import interfaces.physics.PhysicsValue;
import interfaces.physics.Length;

/**
 *
 * @author SaCry Bounding Boxes sind eine einfache Möglichkeit, die Ausdehnung
 * eines physikalischen Objektes anzugeben
 *
 */
public interface BoundingBox extends PhysicsValue, Comparable<BoundingBox> {

    Length length();

    Length width();

    Length height();

    boolean isNull();

    boolean fitsInto(BoundingBox boundingBox);
}
