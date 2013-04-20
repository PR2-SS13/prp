/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation2;

import jgame.JGPoint;
import java.awt.*;
import jgame.platform.JGEngine;

/**
 *
 * @author kbrusch
 */
public class Simulation2 extends JGEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension o = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Simulation2 simulation = new Simulation2(new JGPoint(o.width / 2, o.height / 2));
    }

    private Simulation2(JGPoint jgPoint) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initCanvas() {
    }

    @Override
    public void initGame() {
    }
}
