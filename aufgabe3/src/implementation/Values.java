/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.List.*;
import interfaces.*;
import implementation.*;
/**
 *
 * @author abl563
 */
public class Values {
    
     // convert factors
    public static final Acceleration ACCELERATION_EARTH = AccelerationInMs2.valueOf(9.80665); // Earth acceleration constant in m/sÂ²
    public static final double LEVEL_IN_G = 0.01;
    public static final double GRAM_IN_KG = 1000; // gram to kilo factor
    public static final double TONNE_IN_KG = 0.001; // tonne to kilo factor
    public static final double KG_IN_GRAM = 1000; // gram to kilo factor
    public static final double KG_IN_TONNE = 0.001; // tonne to kilo factor
    public static final double W_IN_KW = 0.001; // watt to kilowatt factor
    public static final double MW_IN_KW = 1000; // megawatt to kilowatt factor
    public static final double KW_IN_W = 1000; // watt to kilowatt factor
    public static final double KW_IN_MW = 0.001; // megawatt to kilowatt factor
    public static final double KMH_IN_MS = 3.6;
    public static final double MHP_IN_MS = 2.2369362920544;
    public static final double M_IN_KM = 0.001; // meter to kilometer factor
    public static final double DEG_IN_RAD = Math.PI / 180.0;
    public static final double RAD_IN_DEG = 180.0 / Math.PI;
    public static final double RADIUS_AS_CIRCUMFERENCE = 2 * Math.PI;
    // zero values
    public static final Length ZERO_LENGTH = LengthInM.valueOf(0d);
    public static final TimeDiff ZERO_TIMEDIFF = TimeDiffInS.valueOf(0d, 0d);
    public static final Speed ZERO_SPEED = SpeedInMS.valueOf(0d);
    public static final Level ZERO_LEVEL = LevelOfPedal.valueOf(0);
    public static final Mass ZERO_MASS = MassInKg.valueOf(0);
    public static final Acceleration ZERO_ACCELERATION = AccelerationInMs2.valueOf(0d);
    public static final Angle ZERO_ANGLE = AngleInRad.valueOf(0d);
    public static final Force ZERO_FORCE = ForceInN.valueOf(0d);
    public static final Power ZERO_POWER = PowerInKw.valueOf(0d);
    public static final Point ZERO_POINT = PointIn2d.valueOf(0, 0);
    public static final Work ZERO_WORK = WorkInNm.valueOf(0d); 
    
}
