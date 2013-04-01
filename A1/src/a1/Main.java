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

    public static void main(String[] args) throws InterruptedException {

        //porsche
        Porsche911GT2RS porsche = new Porsche911GT2RS(1445.0, 456.0, 330.0);

        porsche.reset();
        
        double deltaTime = 1.0;
        double level = 1.0;
        double uptospeed = 100.0;
        
        
        for (double i = 0; i < uptospeed; i++){
            porsche.step(deltaTime+=2.8, level);
            System.out.println("Time: "+porsche.getTime());
            System.out.println("Pos: "+porsche.getPos());
            System.out.println("Speed: "+porsche.getSpeed());
        }
    System.out.println("deltaTime: "+deltaTime);
    }
}
