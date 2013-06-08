/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import implementation.physics.AccelerationInMs2;
import implementation.physics.TimeDiffInS;
import implementation.physics.ForceInN;
import implementation.physics.MassInKg;
import implementation.physics.LengthInM;
import implementation.physics.PowerInW;
import implementation.physics.SpeedInMs;
import interfaces.physics.Acceleration;
import interfaces.physics.Speed;
import interfaces.physics.TimeDiff;
import interfaces.physics.Length;
import interfaces.physics.Mass;
import interfaces.physics.Power;
import interfaces.physics.Force;
import java.util.List.*;

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
    // Mass
    public static final Mass ZERO_MASS = MassInKg.valueOf(0.0);
    public static final double TONS_IN_KG = 1000;
    // Work
    public static final TimeDiff ZERO_TIMEDIFF = TimeDiffInS.valueOf(0.0);
    public static final double M_IN_SECS = 60;
    public static final double H_IN_SECS = M_IN_SECS * 60;
    // Power
    public static final Power ZERO_POWER = PowerInW.valueOf(0.0);
    public static final double KW_IN_WATT = 1000;
    // Acceleration
    public static final Acceleration ZERO_ACC = AccelerationInMs2.valueOf(0.0);
    // Speed 
    public static final Speed ZERO_SPEED = SpeedInMs.valueOf(0.0);
    public static final double KMH_IN_MS = 1.0 / 3.6;
    // Force
    public static final Force ZERO_FORCE = ForceInN.valueOf(0.0);

    // FactoryMethods
    // Length
    public static Length lengthInM(double meters) {
        return LengthInM.valueOf(meters);
    }

    public static Length lengthInFt(double feet) {
        return LengthInM.valueOf(feet * FEET_IN_METERS);
    }

    public static Length lengthInKm(double km) {
        return LengthInM.valueOf(km * KM_IN_METERS);
    }

    // Mass
    public static Mass massInKg(double kg) {
        return MassInKg.valueOf(kg);
    }

    public static Mass massInTon(double ton) {
        return MassInKg.valueOf(ton * TONS_IN_KG);
    }

    // TimeDiff
    public static TimeDiff timeDiffInS(double s) {
        return TimeDiffInS.valueOf(s);
    }

    public static TimeDiff timeDiffInH(double h) {
        return TimeDiffInS.valueOf(h * H_IN_SECS);
    }

    // Force
    public static Force forceInN(double newton) {
        return ForceInN.valueOf(newton);
    }

    // Power
    public static Power powerInW(double watt) {
        return PowerInW.valueOf(watt);
    }

    public static Power powerInKw(double kw) {
        return PowerInW.valueOf(kw * KW_IN_WATT);
    }

    // Acceleration
    public static Acceleration accelerationInMs2(double acc) {
        return AccelerationInMs2.valueOf(acc);
    }

    // SPeed
    public static Speed speedInMs(double ms) {
        return SpeedInMs.valueOf(ms);
    }

    public static Speed speedInKmh(double kmh) {
        return SpeedInMs.valueOf(kmh * KMH_IN_MS);
    }
    //Containerlogistik
    /*
     public static BoundingBox boundingBox(Length length, Length width, Length height) {
     return BoundingBoxImpl.valueOf(length, width, height);
     }

     public static Stowage containerStowage(int bays, int rows, int tiers, Mass maxMass) {
     return ContainerStowageImpl.valueOf(bays, rows, tiers, maxMass);
     }

     public static UniqueId uniqueId(long id) {
     return UniqueIdImpl.valueOf(id);
     }

     public static Name name(String stringName) {
     return Name.valueOf(stringName);
     }
     */
}
