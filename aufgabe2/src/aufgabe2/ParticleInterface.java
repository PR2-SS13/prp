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
    void simulateStep(double deltaTInSeconds, double steps, double traction);
    
    double getXInMeters();

    double getYInMeters();

    double getLevel();
}
