/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

/**
 *
 * @author kbrusch
 */
public class pedal {

    private double level, maxTimeFactorUp, maxTimeFactorDown, lastPressed, timePressed, timeUnpressed;

    public pedal(double upTime, double downTime) {
        maxTimeFactorUp = (1 / upTime);
        maxTimeFactorDown = (1 / downTime);

    }

    //delta time in seconds
    public void step(double deltaTime, boolean isPressed) {

        if (isPressed) {
            timeUnpressed = 0;
            timePressed += deltaTime;
            level = (timePressed) * maxTimeFactorUp;
            level = (level > 1) ? 1 : level;
        } else {
            timePressed = 0;
            timeUnpressed += deltaTime;
            level = (level - (timeUnpressed) + maxTimeFactorDown);
            level = (level <= 0) ? 0 : level;
        }

    }

    public double getLevel() {
        return level;
    }
}
