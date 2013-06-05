package simulation;

import java.util.Set;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.JGFont;
import jgame.platform.JGEngine;

class Engine extends JGEngine {
    
    private long lastFrameAtInMillis = System.currentTimeMillis();
    private Set particles;
    // Graphics
    private final static JGFont lefont = new JGFont("Arial", 1, 8);
    private final static int WINDOW_HEIGHT = 400;
    private double moduloX = WINDOW_HEIGHT;
    private boolean changegraphics = false;
    private final static String[] keybindings = {
        "Level++: KeyRight",
        "Brake: KeyDown",
        "ABS on: 'Q', ABS off: 'W'",
        "ASR on: 'A', ASR off: 'S'",
        "Traction:",
        "'1' = 1.0 , '2' = 0.1 (Ice)",
        "'3' = 0.3 (Snow) , '4' = 0.7 (Wet)",
        "Reset: 'R'"
    };
    // Keyevents
    private static double steps;
    private static double ground = 1.0;
    private static double brake_level;
    private static boolean abs = true;
    private static boolean asr = true;
    private static boolean reset = false;
    
    public Engine(JGPoint size) {
        initEngine(size.x, size.y);
    }
    
    public void setParticles(Set particles) {
        this.particles = particles;
    }
    
    @Override
    public void initCanvas() {
        setCanvasSettings(25, 15, 16, 16, null, new JGColor(255, 255, 255), null);
    }
    
    @Override
    public void initGame() {
        setFrameRate(35, 2);
        defineImage("zangief", "-", 0, "zang_trans.png", "-");
        defineImage("dahlsim", "-", 0, "dahlsim.png", "-");
        defineImage("back", "-", 0, "background.png", "-");
        setBGImage("back");
        lastFrameAtInMillis = System.currentTimeMillis();
    }
    
    @Override
    public void doFrame() {

        // Increase Speed
        if (getKey(KeyRight)) {
            steps += 0.02;
            steps = InRange(steps);
        } else {
            steps = 0.0;
        }

        // Traction
        if (getKey('1')) {
            ground = 1.0;
        } else if (getKey('2')) {
            ground = 0.1;
        } // Ice
        else if (getKey('3')) {
            ground = 0.3;
        } // Snow
        else if (getKey('4')) {
            ground = 0.7;
        } // Wet


        // Break Level
        if (getKey(KeyDown)) {
            brake_level += 0.02;
            brake_level = InRange(brake_level);
        } else {
            brake_level = 0.0;
        }

        // ABS und ASR
        if (getKey('Q')) {
            abs = true;
        } else if (getKey('W')) {
            abs = false;
        } else if (getKey('A')) {
            asr = true;
        } else if (getKey('S')) {
            asr = false;
        }
        
        if (getKey('R')) {
            reset = true;
        }
        
        System.out.println("ABS: " + abs + " ASR: " + asr);
        long currentMillis = System.currentTimeMillis();
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            particle.simulateStep((float) (currentMillis - lastFrameAtInMillis) / 1000,
                    steps, ground, brake_level, abs, asr);
        }
        lastFrameAtInMillis = System.currentTimeMillis();
    }
    
    private double InRange(double num) {
        if (num >= 1.0) {
            return 1.0;
        } else if (num <= 0.0) {
            return 0.0;
        }
        return num;
    }
    
    private void resetIt(ParticleInterface particle) {
        if (reset) {
            particle.reset();
            reset = false;
            changegraphics = false;
            abs = true;
            asr = true;
            ground = 1.0;
            steps = 0.0;
            moduloX = WINDOW_HEIGHT;
        }
    }
    
    @Override
    public void paintFrame() {
        setColor(JGColor.black);
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            drawAny(keybindings, 10, 180);
            drawAny(particle.getHubArr(), 15, 15);
            drawCharacters(particle);
            resetIt(particle);
        }
    }
    
    private void drawCharacters(ParticleInterface particle) {
        if (particle.getAbflug()) {
            drawString("ABFLUCH!! Y0LOO!!", 200, 60, 0,
                    new JGFont("Arial", 1, 20), JGColor.black);
        }
        drawOneCharacter(particle);
    }
    
    private void drawOneCharacter(ParticleInterface particle) {
        double x = particle.getXInMeters(), y = particle.getYInMeters();
        if (particle.getPos() >= moduloX) {
            this.changegraphics = !this.changegraphics;
            moduloX += WINDOW_HEIGHT;
        }
        if (changegraphics) {
            drawImage(x, y, "dahlsim", JGColor.black, 0.0, 1.0, 0.3, true);
        } else {
            drawImage(x, y, "zangief", JGColor.black, 0.0, 1.0, 0.3, true);
        }
    }
    
    private void drawAny(String[] towrite, int xoff, int yoff) {
        int beforeyoff = yoff;
        for (int x = 0; x < towrite.length; x++) {
            if (x % 4 == 0 && x != 0) {
                xoff += 100;
                yoff = beforeyoff;
            }
            drawString(towrite[x], xoff, yoff, -1, lefont, JGColor.white);
            yoff += 10;
        }
    }
}