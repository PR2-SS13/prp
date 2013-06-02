package simulation;

/**
 *
 * @author Marvin
 */
public interface ParticleInterface {

    /**
     *
     * @param deltaTInSeconds
     */
    void simulateStep(double deltaTInSeconds, double steps, double ground_,
            double break_level, boolean abs, boolean asr);

    double getXInMeters();

    double getYInMeters();

    double getLevel();

    double getPos();
    // My Interface Methods

    void reset();

    boolean getAbflug();

    String[] getHubArr();
}
