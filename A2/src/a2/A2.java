/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import jgame.*;
import jgame.platform.*;

/**
 *
 * @author kbrusch
 */
public class A2 extends JGEngine{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new A2(new JGPoint(1024, 768));
        //new JGPoint 
    }

    public A2() {
        initEngineApplet();
    }
    
    public A2(JGPoint size) {
        initEngine(size.x,size.y);
    }

    @Override
    public void initCanvas() {
        setCanvasSettings(20,  15,  16,  16,  null,null,null);
    }

    @Override
    public void initGame() {
        setFrameRate(35,2);
    }
    
    
	/** A timer used to animate the "hello world" text. */
	double texttimer=0;

	/** Game logic is done here.  No painting can be done here, define
	* paintFrame to do that. */
	public void doFrame() {
		// Increment the angle of the moving text.
		texttimer += 5;
	}

	/** Any graphics drawing beside objects or tiles should be done here.
	 * Usually, only status / HUD information needs to be drawn here. */
	public void paintFrame() {
		setColor(JGColor.red);
		// Draw a text that moves around in a circle.
		// Note: viewWidth returns the width of the view;
		//       viewHeight the height.
		drawString("Yolo",
			30, //viewWidth()/2  + 50*Math.sin(texttimer), xpos
			viewHeight()/2 + 30+texttimer, // ypos
			0 // the text alignment
			  // (-1 is left-aligned, 0 is centered, 1 is right-aligned)
		);
	}
}
