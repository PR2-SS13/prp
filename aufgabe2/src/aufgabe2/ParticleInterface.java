package aufgabe2;

/**
 *
 * @author Marvin
 */
public interface ParticleInterface {

    /**
     *
     * @param deltaTInSeconds
     */
    void simulateStep(double deltaTInSeconds, double steps, double traction,
            double break_level, boolean abs, boolean asr);

    double getXInMeters();

    double getYInMeters();

    double getLevel();

    // My Interface Methods
    void reset();

    double getSpeed();

    double getTime();

    double getPos();

}
