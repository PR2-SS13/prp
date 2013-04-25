package aufgabe2;

import java.util.Set;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;

class Engine extends JGEngine {

    private long lastFrameAtInMillis = System.currentTimeMillis();
    private Set particles;
    private static final int D = 68; // forward
    private static final int A = 65; // back
    private static final int S = 83; // break
    private static final int W = 87; // Traction Ice
    private static final int E = 69; // Traction Snow
    private static final int R = 82; // Traction Wet

    public Engine(JGPoint size) {
        initEngine(size.x, size.y);
    }

    public void setParticles(Set particles) {
        this.particles = particles;
    }

    public void initCanvas() {
        setCanvasSettings(20, 15, 16, 16, null, new JGColor(255, 255, 255), null);
    }

    @Override
    public void initGame() {
        setFrameRate(35, 2);
        lastFrameAtInMillis = System.currentTimeMillis();
    }
    private static double steps = 0.0;
    private static double traction = 1.0;

    @Override
    public void doFrame() {

        if (getKey(D)) {steps += 0.1; /* increase speed */} 
        else { steps = 0.0;}
        
        if (getKey(A)) {steps -= 0.1; /* decrease speed */}
        
        //if (getKey(S)) { /* breaks */}
        
        if (getKey(W)) {traction = 0.1;} // Ice
        else if (getKey(E)) {traction = 0.3;} // Snow
        else if (getKey(R)) {traction = 0.7;} // Wet
        else if (getKey(S)) {traction = 0.0;} // None
        else traction = 1.0;

        long currentMillis = System.currentTimeMillis();
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            particle.simulateStep((float) (currentMillis - lastFrameAtInMillis) / 1000, steps, traction);
        }
        lastFrameAtInMillis = System.currentTimeMillis();
    }

    @Override
    public void paintFrame() {
        setColor(JGColor.black);
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            drawOval(particle.getXInMeters(), particle.getYInMeters(), 5, 5, true, true);
        }
    }
}