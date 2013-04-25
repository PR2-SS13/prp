/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

/**
 *
 * @author kbrusch
 */
public class Porsche911 implements ParticleInterface{

    // 
    private double mass;
    private double powerPropMax; // KW -> (kg*m^2)/s^3
    private double speedMax; // MS
    private double speed; // MS
    private double level;
    private double pos;
    private double time; // MilS
    
    // Class Constants
    private static final double ACC_EARTH = 9.81; // M / S²
    private static final double KMH_IN_MS = (1 / 3.6);
    private static final double KILO = 1000;

    public Porsche911(double mass, double powerPropMax, double speedMax) {
        this.mass = mass; // KG
        this.powerPropMax = powerPropMax * KILO;
        this.speedMax = speedMax * KMH_IN_MS;
    }

    public void set(double time, double pos, double speed, double level) {
        this.speed = speed;
        this.level = level;
        this.pos = pos;
        this.time = time;
    }

    public void reset() {
        set(0.0, 0.0, 0.0, 0.0);
    }

    public String toString_NSI() {
        return "Time: " + this.time + " MilSec"
                + " - Position: " + this.pos
                + " - Speed: " + this.speed / KMH_IN_MS + " KM/H"; //converting back to KM/H
    }

    public String toString_SI() {
        return "Time: " + this.time + " MilSec"
                + " - Position: " + this.pos
                + " - Speed: " + this.speed + " MS";
    }

    public void step(double deltaTime, double level) {

        double powerProp; // level*(kg*m*s^2)
        double forcePropMax; // kg*m*s^-2
        double forcePropAbs; // kg*m*s^-2
        double forceProp; // kg*m*s^-2
        double dragConst; // kg/m
        double forceDrag; // kg*m*s^-2
        double force; // kg*m*s^-2
        double acc; // m/s^2
        this.level = level;

        // Dynamik
        powerProp = Math.abs(this.level) * this.powerPropMax;
        forcePropMax = this.mass * ACC_EARTH;
        forcePropAbs = Math.min(forcePropMax, powerProp / Math.abs(this.speed));
        forceProp = forcePropAbs * Math.signum(this.level);
        dragConst = Math.abs(powerProp / (Math.pow(this.speedMax, 3.0)));
        forceDrag = dragConst * Math.pow(this.speed, 2.0) * Math.signum(-(this.speed));
        force = forceProp + forceDrag;

        // Kinematik
        this.pos = this.pos + (this.speed * deltaTime);
        acc = force / this.mass;
        this.speed = this.speed + (acc * deltaTime);
        this.time = (this.time + deltaTime);
    }

    // Getter & Setter
    public double getSpeed() { return speed;}
    public void setSpeed(double speed) {this.speed = speed;}

    public double getPos() {return pos;}
    public void setPos(double pos) {this.pos = pos;}

    public double getTime() {return time;}
    public void setTime(double time) {this.time = time;}

    public double getMass() {return mass;}
    public void setMass(double mass) {this.mass = mass;}

    public double getPowerPropMax() {return powerPropMax;}
    public void setPowerPropMax(double powerPropMax) {this.powerPropMax = powerPropMax;}

    public double getSpeedMax() {return speedMax;}
    public void setSpeedMax(double speedMax) {this.speedMax = speedMax;}

    @Override
    public void simulateStep(float deltaTInSeconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getXInMeters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getYInMeters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getLevel() {
        return (float) this.level;
    }
    
}
