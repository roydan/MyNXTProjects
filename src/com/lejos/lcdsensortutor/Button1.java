package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Buttons
 *
 * The Button class has four instances, accessed by static fields:
 *   Button.ENTER
 *   Button.ESCAPE
 *   Button.LEFT
 *   Button.RIGHT
 * 
 * id code of the button that is pressed
 * button	ENTER	LEFT	RIGHT	ESCAPE
 * Code     1       2       4       8
 */
public class Button1 {

	public static void main(String[] args) throws Exception {
		LCD.drawString("Button1", 0, 0);
	    Button.waitForAnyPress();

		while (true) {
		    if (Button.ENTER.isDown()) {
				LCD.clear();
		    	LCD.drawString("ENTER", 0, 0);
		    }
		    if (Button.LEFT.isDown()) {
				LCD.clear();
		    	LCD.drawString("LEFT", 0, 0);
		    }
		    if (Button.RIGHT.isDown()) {
				LCD.clear();
		    	LCD.drawString("RIGHT", 0, 0);
		    }
		    if (Button.ESCAPE.isDown())	{
				LCD.clear();
		    	LCD.drawString("ESCAPE", 0, 0);
		    	break;
		    }
		}
	    Button.waitForAnyPress();
	    
		LCD.clear();
		Button.ENTER.waitForPressAndRelease();
	    LCD.drawString("ENTER", 0, 0);
	    Button.waitForAnyPress();

		int id;
	    
		while (true) {
			id = Button.waitForAnyPress();
			LCD.clear();
		    LCD.drawString("Button: " + id, 0, 0);
		    if (id == 8) {
		    	// ESCAPE
		    	break;
		    }
		}
	    Button.waitForAnyPress();
	}

}
