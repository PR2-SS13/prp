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

    private double mass;
    private double powerPropMax;
    private double speedMax;
    private double speed;
    private double level;
    private double pos;
    private double time;

    public Porsche911GT2RS(double mass, double powerPropMax, double speedMax) {
        this.mass = mass;
        this.powerPropMax = powerPropMax;
        this.speedMax = speedMax;
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

    public void step(double deltaTime, double level) {

        double accEarth = 9.81;
        this.level = level;



        //dynamik

        double powerProp = Math.abs(this.level) * this.powerPropMax;
        double forcePropMax = this.mass * accEarth;
        double forcePropAbs = Math.min(forcePropMax, powerProp / Math.abs(this.speed));
        double forceProp = forcePropAbs * Math.signum(this.level);
        double dragConst = Math.abs(powerProp / (Math.pow(this.speedMax, 3.0)));
        double forceDrag = dragConst * Math.pow(this.speed, 2.0) * Math.signum(-(this.speed));
        double force = forceProp + forceDrag;

        //Kinematik
        this.pos = this.pos + (this.speed * deltaTime);
        this.time = (this.time + deltaTime);
        double acc = force / this.mass;
        this.speed = this.speed + (acc * deltaTime);


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