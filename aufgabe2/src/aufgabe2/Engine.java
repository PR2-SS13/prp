package aufgabe2;

import java.util.Set;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.JGFont;
import jgame.platform.JGEngine;
import java.text.DecimalFormat;

class Engine extends JGEngine {

    private long lastFrameAtInMillis = System.currentTimeMillis();
    private Set particles;
    public static boolean abflug = false;
    private DecimalFormat df = new DecimalFormat("0.00##");

    public Engine(JGPoint size) {
        initEngine(size.x, size.y);
    }

    public void setParticles(Set particles) {
        this.particles = particles;
    }

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
    private static double steps;
    private static double traction = 1.0;
    private static double brake_level;
    private boolean abs = true;
    private boolean asr = true;
    private boolean reset = false;

    @Override
    public void doFrame() {

        // Increase Speed
        if (getKey(KeyRight)) {
            steps += 0.1;
            steps = InRange(steps);
        } else {
            steps = 0.0;
        }

        // Traction
        if (getKey('1')) {
            traction = 1.0;
        } else if (getKey('2')) {
            traction = 0.1;
        } // Ice
        else if (getKey('3')) {
            traction = 0.3;
        } // Snow
        else if (getKey('4')) {
            traction = 0.7;
        } // Wet


        // Break Level
        if (getKey(KeyDown)) {
            brake_level += 0.1;
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
                    steps, traction, brake_level, abs, asr);
        }
        lastFrameAtInMillis = System.currentTimeMillis();
    }

    private double InRange(double num) {
        if (num > 1.0) {
            return 1.0;
        } else if (num < 0.0) {
            return 0.0;
        }
        return num;
    }
    
    // Callback from engine (getxpos method) if at the side x > 400 change characters
    public static boolean changegraph = false;

    @Override
    public void paintFrame() {
        setColor(JGColor.black);
        drawHub();
        //drawStreet();
        for (Object value : particles) {
            ParticleInterface particle = (ParticleInterface) value;
            drawCharacters(particle);
            resetIt(particle);
        }
    }

    private void drawCharacters(ParticleInterface particle) {
        if (abflug) {
            drawString("ABFLUCH!! Y0LOO!!", 200, 60, 0, new JGFont("Arial", 1, 20), JGColor.black);
            int rand = (int) ((Math.random() - 0.5) * 2 * 30);
            if (changegraph) {
                drawImage(particle.getXInMeters(), particle.getYInMeters() + rand, "dahlsim", JGColor.black, 1.0, 1.0, 0.3, true);
            } else {
                drawImage(particle.getXInMeters(), particle.getYInMeters() + rand, "zangief", JGColor.black, 1.0, 1.0, 0.3, true);
            }
        } else {
            // Callback from engine (getxpos method) if at the side x > 400 change characters
            if (changegraph) {
                drawImage(particle.getXInMeters(), particle.getYInMeters(), "dahlsim", JGColor.black, 0.0, 1.0, 0.3, true);
            } else {
                drawImage(particle.getXInMeters(), particle.getYInMeters(), "zangief", JGColor.black, 0.0, 1.0, 0.3, true);
            }
        }
    }
    // For keybindings - iterating in drawHub() with for (String e : keybindings)
    private static String[] keybindings = {
        "Traction: '1' = 1.0 , '2' = 0.1 (Ice) , '3' = 0.3 (Snow) , '4' = 0.7 (Wet)",
        "Pedal: accelerate = KeyRight , brake = KeyDown",
        "abs on: 'Q', abs off: 'W' - asr on: 'A', asr off: 'S'",
        "Reset: 'R'"
    };

    private void drawHub() {
        JGFont lefont = new JGFont("Arial", 1, 8);
        String formatPedal = df.format(this.steps);
        String formatBrakes = df.format(this.brake_level);
        drawString("Traction: " + this.traction + " Pedal: "
                + formatPedal, 15, 15, -1, lefont, JGColor.white);
        drawString("Brakes: " + formatBrakes, 15, 25, -1, lefont, JGColor.white);
        drawString("abs: " + this.abs + " asr: "
                + this.asr, 15, 35, -1, lefont, JGColor.white);
        int xoff = 10, yoff = 180;
        for (String key : keybindings) {
            drawString(key, xoff + 5, yoff += 10, -1,
                    lefont, JGColor.white);
        }
    }

    private void drawStreet() {
        drawLine(800.0, 70.0, 1.0, 70.0);
        drawLine(800.0, 90.0, 1.0, 90.0);
    }

    private void resetIt(ParticleInterface particle) {
        if (reset) {
            particle.reset();
            reset = false;
            abs = true;
            asr = true;
            traction = 1.0;
            steps = 0.0;
        }
    }
}