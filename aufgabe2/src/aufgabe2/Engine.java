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
    
    public static boolean abflug = false;
    
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
    private static double steps;
    private static double traction;
    private static double break_level;
    private boolean abs = true;
    private boolean asr = true;

    @Override
    public void doFrame() {

        // Increase Speed
        if (getKey(D)) {
            steps += 0.1;
        } else {
            steps = 0.0;
        }

        // Traction
        if (getKey(W)) {
            traction = 0.1;
        } // Ice
        else if (getKey(E)) {
            traction = 0.3;
        } // Snow
        else if (getKey(R)) {
            traction = 0.7;
        } // Wet
        else {
            traction = 1.0;
        }

        // Break Level
        if (getKey(S)) {
            break_level += 0.1;
        } else {
            break_level = 0.0;
        }

        // ABS und ASR
        if (getKey((int)'G')) {
            abs = true;
        } else if (getKey((int)'H')) {
            abs = false;
        } else if (getKey((int)'B')) {
            asr = true;
        } else if (getKey((int)'N')) {
            asr = false;
        }
        
        System.out.println("ABS: " + abs + " ASR: " + asr);

        long currentMillis = System.currentTimeMillis();
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            particle.simulateStep((float) (currentMillis - lastFrameAtInMillis) / 1000,
                    steps, traction, break_level, abs, asr);
        }
        lastFrameAtInMillis = System.currentTimeMillis();
    }

    @Override
    public void paintFrame() {
        setColor(JGColor.black);
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            if (abflug){
                System.out.println("ABFLUCH!!!!!yolo");
                int rand = (int)((Math.random()-0.5)*2*30);
                drawOval(particle.getXInMeters(), particle.getYInMeters()+rand, 5, 5, true, true);
            }else{
                drawOval(particle.getXInMeters(), particle.getYInMeters(), 5, 5, true, true);
            }
        }
    }
    
    
}