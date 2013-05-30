package aufgabe2;

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
        aufgabe2.Engine.abflug = false;
    }

    public final void reset() {
        set(0.0, 0.0, 0.0, 0.0);
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

        powerProp = Math.abs(level) * powerPropMax;
        forcePropMax = mass * ACC_EARTH * this.traction;
        forcePropAbs = (speed == 0) ? ACC_EARTH : powerProp / Math.abs(speed);
        forceProp = forcePropAbs * Math.signum(level);
        dragConst = Math.abs(powerPropMax / (Math.pow(speedMax, 3)));
        forceDrag = dragConst * Math.pow(speed, 2) * Math.signum(-speed);

        forceBreak = (brake_level * mass * ACC_EARTH) * Math.signum(-speed);
        force = forceProp + forceDrag + forceBreak;

        if (Math.abs(force) > forcePropMax) {
            //ABS, ASR
            if (Math.abs(forceBreak) > forcePropAbs) {
                if (abs == false) {
                    forceBreak = abs_force(forceBreak);
                    aufgabe2.Engine.abflug = true;
                }
            } else //if (Math.abs(force_brake) < forcePropAbs) {
            {
                if (asr == false) {
                    forceBreak = asr_force(forceBreak);
                    aufgabe2.Engine.abflug = false;
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

    public double asr_force(double force_brake_) {
        return (force_brake_) / 2;
    }

    public double abs_force(double force_brake_) {
        return (force_brake_) / 8;
    }

    // Getter & Setter
    public double getSpeed() {
        return speed / KMH_IN_MS;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

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
        if (this.pos >= 400) {
            this.pos = 0.0;
            aufgabe2.Engine.changegraphics = !aufgabe2.Engine.changegraphics;
        }
        return this.pos % 400;
    }

    @Override
    public double getYInMeters() {
        return 80.0;
    }

    @Override
    public double getLevel() {
        return this.level;
    }
}
