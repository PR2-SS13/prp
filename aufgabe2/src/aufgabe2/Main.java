/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

import java.awt.Dimension;
import jgame.JGPoint;

/**
 *
 * @author kbrusch
 */
public class Main {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension o = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Porsche911 p = new Porsche911(1445.0, 456.0, 330.0);
        Simulation2 simulation = new Simulation2(p, new JGPoint(o.width / 2, o.height / 2));
    }
    
    
}
