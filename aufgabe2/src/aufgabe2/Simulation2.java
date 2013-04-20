/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

import jgame.JGPoint;
import jgame.platform.JGEngine;

/**
 *
 * @author kbrusch
 */
public class Simulation2 extends JGEngine {

    private Porsche911 porsche;
    
    public Simulation2(Porsche911 p, JGPoint jgPoint) {
        this.porsche = p;
    }

    @Override
    public void initCanvas() {
    }

    @Override
    public void initGame() {
    }
}
