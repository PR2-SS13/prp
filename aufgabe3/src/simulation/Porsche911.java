package simulation;

import java.text.DecimalFormat;

public class Porsche911 implements ParticleInterface {

    // Constants
    private double mass;
    private double powerPropMax; // KW -> (kg*m^2)/s^3
    private double speedMax; // MS
    private double speed; // MS
    private double level;
    private double pos;
    private double time; // MilS
    private double traction = 1.0;
    private boolean abflug = false;
    private double brake_level = 0.0;
    private boolean abs = true;
    private boolean asr = true;
    // Class Constants
    private static final double ACC_EARTH = 9.81; // M / S²
    private static final double KMH_IN_MS = (1 / 3.6);
    private static final double KILO = 1000;

    public Porsche911(double mass, double powerPropMax, double speedMax) {
        this.mass = mass; // KG
        this.powerPropMax = powerPropMax * KILO;
        this.speedMax = speedMax * KMH_IN_MS;
        reset();
    }

    public void set(double time, double pos, double speed, double level) {
        this.speed = speed;
        this.level = level;
        this.pos = pos;
        this.time = time;
    }

    @Override
    public final void reset() {
        set(0.0, 0.0, 0.0, 0.0);
        this.abs = true;
        this.asr = true;
        this.traction = 1.0;
        this.level = 0.0;
        this.abflug = false;
    }

    public String toString_NSI() {
        return "Time: " + this.time + " MilSec"
                + " - Position: " + this.pos
                + " - Speed: " + this.speed / KMH_IN_MS + " KM/H"; //converting back to KM/H
    }

    public static void pr(Object a) {
        System.out.println(a);
    }

    public String toString_SI() {
        return "Time: " + this.time + " MilSec"
                + " - Position: " + this.pos
                + " - Speed: " + this.speed + " MS";
    }

    public void step(double deltaTime, double level, double traction,
            double brake_level, boolean abs, boolean asr) {

        double powerProp; // level*(kg*m*s^2)
        double forcePropMax; // kg*m*s^-2
        double forcePropAbs; // kg*m*s^-2
        double forceProp; // kg*m*s^-2
        double dragConst; // kg/m
        double forceDrag; // kg*m*s^-2
        double force; // kg*m*s^-2
        double acc; // m/s^2
        double forceBreak;
        this.level = level;
        this.traction = traction;
        this.brake_level = brake_level;
        this.abs = abs;
        this.asr = asr;

        powerProp = Math.abs(level) * powerPropMax;
        forcePropMax = mass * ACC_EARTH * this.traction;
        forcePropAbs = (speed == 0) ? ACC_EARTH : powerProp / Math.abs(speed);
        forceProp = forcePropAbs * Math.signum(level);
        dragConst = Math.abs(powerPropMax / (Math.pow(speedMax, 3)));
        forceDrag = dragConst * Math.pow(speed, 2) * Math.signum(-speed);

        forceBreak = (this.brake_level * mass * ACC_EARTH) * Math.signum(-speed);
        force = forceProp + forceDrag + forceBreak;

        if (Math.abs(force) > forcePropMax) {
            //ABS, ASR
            if (Math.abs(forceBreak) > forcePropAbs) {
                if (this.abs == false) {
                    forceBreak = abs_force(forceBreak);
                    this.abflug = true;
                }
            } else //if (Math.abs(force_brake) < forcePropAbs) {
            {
                if (this.asr == false) {
                    forceBreak = asr_force(forceBreak);
                    this.abflug = true;
                }
                //Wenn beide nicht an, dann Abflug;
            }
        }

        force = Math.min(forcePropMax, force); // Physisch
        acc = force / mass;

        speed += acc * deltaTime;
        pos += speed * deltaTime;
        time += deltaTime;

        // Kinematik
        System.out.println(toString_NSI());
    }

    @Override
    public boolean getAbflug() {
        return this.abflug;
    }

    public double asr_force(double force_brake_) {
        return (force_brake_) / 2;
    }

    public double abs_force(double force_brake_) {
        return (force_brake_) / 8;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getPowerPropMax() {
        return powerPropMax;
    }

    public void setPowerPropMax(double powerPropMax) {
        this.powerPropMax = powerPropMax;
    }

    public double getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(double speedMax) {
        this.speedMax = speedMax;
    }

    @Override
    public void simulateStep(double deltaTInSeconds, double steps, double traction,
            double break_level, boolean abs, boolean asr) {
        step(deltaTInSeconds, steps, traction, break_level, abs, asr);
    }

    @Override
    public double getXInMeters() {
        return this.pos % 400;
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
    private DecimalFormat df = new DecimalFormat("0.00##");

    @Override
    public String[] getHubArr() {
        String[] hub = {
            "Speed: " + df.format(this.speed / KMH_IN_MS),
            "Traction: " + this.traction,
            "Pedal-Level: " + df.format(this.level),
            "Brakes: " + df.format(this.brake_level),
            "Time: " + df.format(this.time),
            "Position: " + df.format(this.pos),
            "X-Position: " + df.format(getXInMeters()),
            "Y-Position: " + df.format(getYInMeters()),
            "ABS: " + this.abs,
            "ASR: " + this.asr,};
        return hub;
    }
}
