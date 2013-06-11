package implementation.physics;

import interfaces.physics.PhysicsScalar;

/**
 *
 * @author abl563
 */
public abstract class AbstractScalar<T> extends AbstractValue
        implements PhysicsScalar<T> {

    protected static int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    }
}
