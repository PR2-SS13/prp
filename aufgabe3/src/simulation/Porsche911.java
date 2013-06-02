package simulation;

import java.text.DecimalFormat;
import implementation.*;
import interfaces.*;

public class Porsche911 implements ParticleInterface {

    private DecimalFormat df = new DecimalFormat("0.00##");
    // API Variables
    private Mass mass;
    private Power powerPropMax; // KW -> (kg*m^2)/s^3
    private Speed speedMax;
    private Speed speed;
    private Force forcePropMax;
    private Force forcePropAbs;
    private Force force;
    private Force forceDrag;
    private Acceleration acc;
    private Length pos;
    private TimeDiff time; // MilS
    // Non-API Types
    private double level;
    private double brake_level;
    private double dragConst;
    private boolean abs = true, asr = true;
    private boolean abflug = false;
    // Constants
    private double ground;
    final static Acceleration ACC_EARTH = Values.accelerationInMs2(9.80665); // M / S²

    public Porsche911(double mass_, double powerPropMax_, double speedMax_, double ground_) {
        mass = Values.massInKg(mass_);
        powerPropMax = Values.powerInW(powerPropMax_);
        // MaximumSpeed
        speedMax = Values.speedInKmh(speedMax_);
        // Windwiderstand
        dragConst = Math.abs(powerPropMax.watt() / (speedMax.mul(speedMax).mul(speedMax)).ms());
        this.ground = ground_;
        set(0.0, 0.0, 0.0, 0.0);
    }

    public void set(double time_, double pos_, double speed_, double level_) {
        time = Values.timeDiffInS(time_);
        speed = Values.speedInMs(speed_);
        pos = Values.lengthInM(pos_);
        level = level_;
    }

    @Override
    public final void reset() {
        set(0.0, 0.0, 0.0, 0.0);
        this.ground = 1.0;
        this.abs = true;
        this.asr = true;
        this.level = 0.0;
        this.abflug = false;
    }

    @Override
    public String toString() {
        return "Time: " + this.time + "\n"
                + "Position: " + this.pos + "\n"
                + "Speed: " + this.speed + "\n"
                + "Mass: " + this.mass + "\n"
                + "speedMax: " + this.speedMax + "\n"
                + "Force: " + this.force + "\n"
                + "Acc: " + this.acc + "\n"
                + "forcePropMax: " + this.forcePropMax + "\n"
                + "powerPropMax: " + this.powerPropMax + "\n"
                + "forcePropAbs: " + this.forcePropAbs + "\n"
                + "forceDrag: " + this.forceDrag + "\n"
                + "dragConst: " + this.dragConst + "\n"
                + "Level: " + this.level + "\n"
                + "BrakeLevel: " + this.brake_level + "\n"
                + "Ground: " + this.ground + "\n";
    }

    public void step(double deltaTime, double level_, double ground_,
            double brakeLevel_, boolean abs_, boolean asr_) {

        this.level = level_;
        this.brake_level = brakeLevel_;
        this.abs = abs_;
        this.asr = asr_;
        this.ground = ground_;

        Power powerProp = this.powerPropMax.mul(Math.abs(this.level));
        forcePropMax = mass.mul(this.ground).mul(ACC_EARTH);
        this.forcePropAbs = (this.speed.isZero()) ? forcePropMax : Values.forceInN(powerProp.div(this.speed.abs().ms()).watt());
        Force forceProp = forcePropAbs.mul(Math.signum(level));
        this.forceDrag = Values.forceInN(this.speed.mul(this.speed).mul(this.dragConst).mul(Math.signum(-this.speed.ms())).ms());

        Force forcePropBrake = this.mass.mul(ACC_EARTH).mul(this.brake_level).mul(Math.signum(-this.speed.ms()));
        this.force = forceProp.add(forceDrag).add(forcePropBrake);

        if (this.force.abs().compareTo(this.forcePropMax) == 1) {
            if (forcePropBrake.abs().compareTo(forcePropAbs) == 1) {
                if (this.abs == false) {
                    this.abflug = true;
                }
            } else {
                if (this.asr == false) {
                    this.abflug = true;
                }
            }
        }

        this.force = Values.forceInN(Math.min(this.force.newton(), this.forcePropMax.newton()));

        TimeDiff dTime = Values.timeDiffInS(deltaTime);
        this.acc = this.force.div(this.mass);
        this.speed = this.speed.add(this.acc.mul(dTime));
        this.pos = this.pos.add(this.speed.mul(dTime));
        this.time = this.time.add(dTime);

        System.out.println(toString());
    }

    @Override
    public boolean getAbflug() {
        return this.abflug;
    }

    @Override
    public void simulateStep(double deltaTInSeconds, double steps, double ground_,
            double break_level, boolean abs, boolean asr) {
        step(deltaTInSeconds, steps, ground_, break_level, abs, asr);
    }

    @Override
    public double getXInMeters() {
        return this.pos.m() % 400;
    }

    @Override
    public double getYInMeters() {
        if (abflug) {
            return 80.0 + (int) ((Math.random() - 0.5) * 2 * 30);
        } else {
            return 80.0;
        }
    }

    @Override
    public double getLevel() {
        return this.level;
    }

    @Override
    public double getPos() {
        return this.pos.m();
    }

    @Override
    public String[] getHubArr() {
        String[] hub = {
            "Speed: " + df.format(this.speed.kmh()),
            "Pedal-Level: " + df.format(this.level),
            "Brakes: " + df.format(this.brake_level),
            "Time: " + df.format(this.time.sec()),
            "Position: " + df.format(this.pos.m()),
            "X-Position: " + df.format(getXInMeters()),
            "Y-Position: " + df.format(getYInMeters()),
            "ABS: " + this.abs,
            "ASR: " + this.asr};
        return hub;
    }
}
