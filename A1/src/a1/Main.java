/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a1;

/**
 *
 * @author kbrusch, nitsche
 */
public class Main {

    public static void main(String[] args) {

        Porsche911GT2RS porsche = new Porsche911GT2RS(1445.0, 456.0, 330.0);
        porsche.reset();

        double deltaTime = 0.01;
        double level = 1.0;
        
        int iter = 20000;
        for (double i = 0; i < iter; i++) {

            porsche.step(deltaTime, level);
            System.out.println(porsche.toString());
            
        }
        
    }
}
