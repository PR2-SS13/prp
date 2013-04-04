/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

/**
 *
 * @author kbrusch, nitsche
 */
public class Porsche911GT2RS {

    // 
    private double mass; // KG
    private double powerPropMax; // KW -> (kg*m^2)/s^3
    private double speedMax; // MS
    private double speed; // MS
    private double level; // 
    private double pos; //
    private double time; //
    
    // Class Constants
    private static final double ACC_EARTH = 9.81; // M / S²
    private static final double KMH_IN_MS = (1/3.6);
    private static final double KILO = 1000;
   

    public Porsche911GT2RS(double mass, double powerPropMax, double speedMax) {
        this.mass = mass; // KG
        this.powerPropMax = powerPropMax*KILO;
        this.speedMax = speedMax*KMH_IN_MS;
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

    @Override
    public String toString() {
        return "Time: " + this.time
                + " Position: " + this.pos
                + " Speed: " + this.speed/KMH_IN_MS;
    }

    public void step(double deltaTime, double level) {

        double powerProp; //
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
        // Newton (kg*m/s²) = kg * m/s²
        forcePropMax = this.mass * ACC_EARTH;
        // Newton (kg*m/s²) = 
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

    public double getTime() {
        return time;
    }

    public double getPos() {
        return pos;
    }

    public double getSpeed() {
        return speed;
    }
}