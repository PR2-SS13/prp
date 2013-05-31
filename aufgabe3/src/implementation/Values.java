/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.List.*;
import interfaces.*;

/**
 *
 * @author abl563
 */
public final class Values {

    private Values() {
    }
    // Length
    public static final Length ZERO_LENGTH = LengthInM.valueOf(0d);
    public static final double FEET_IN_METERS = 0.3048;
    public static final double KM_IN_METERS = 1000;
    // Force
    //public static final Force ZERO_FORCE = ForceInN.valueOf(0.0);
    // Mass
    //public static final Mass ZERO_MASS = MassInKg.valueOf(0.0);
    public static final double TONS_IN_KG = 1000;
    // Power
    //public static final Power ZERO_POWER = PowerInKw.valueOf(0.0);
    public static final double KW_IN_WATT = 1000;
    // Work
    //public static final TimeDiff ZERO_TIMEDIFF = TimeDiffInS.valueOf(0.0);
    public static final double M_IN_SECS = 60;
    public static final double H_IN_SECS = M_IN_SECS * 60;
    // Acceleration
    public static final Acceleration ZERO_ACC = null; //AccelerationInMs2.valueOf(0.0);
    // Speed 
    //public static final Speed ZERO_SPEED = SpeedInMs.valueOf(0.0);
    public static final double KMH_IN_MS = 1.0 / 3.6;
    // FactoryMethods
}
