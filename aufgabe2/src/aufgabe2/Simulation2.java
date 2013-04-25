/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

import jgame.JGColor;
import jgame.JGObject;
import jgame.JGPoint;
import jgame.platform.JGEngine;

/**
 *
 * @author kbrusch
 */
public class Simulation2 extends JGEngine {

    private Porsche911 porsche;
    private static double ICE = 0.1;
    private static double SNOW = 0.3;
    private static double WET = 0.7;
    

    public Simulation2() {
        this.initEngineApplet();
    }

    public Simulation2(Porsche911 p, JGPoint jgPoint) {
        super();
        this.porsche = p;
        this.initEngine(jgPoint.x, jgPoint.y);
    }

    @Override
    public void initCanvas() {
        this.setCanvasSettings(800, 400, 1, 1, JGColor.yellow, JGColor.yellow, null);
    }

    @Override
    public void initGame() {
        setFrameRate(35, 2);
        JGObject jgob = new JGObject("Background", true, 0, 0, 1, "background");
        porsche.reset();
        setGameState("Wait");
    }
    
    public void doFrame(){
        
        getKey(12);
        
    }
    
    
    
}
