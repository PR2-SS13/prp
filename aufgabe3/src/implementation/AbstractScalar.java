package implementation;

import interfaces.PhysicsScalar;

/**
 *
 * @author abl563
 */
public abstract class AbstractScalar<T> extends AbstractValue<T> 
            implements PhysicsScalar<T> {
    
    protected static int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    } 
    
}
