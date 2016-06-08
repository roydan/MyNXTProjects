package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * LCD Text methods
 *
 * As a text display, the NXT LCD screen is 16 char. wide and 8 char. deep.
 * It is addressed using (x, y) co-ordinates as follows:
 * x ranges from 0 to 15 (left to right),
 * y from 0 to 7 (from top to bottom)
 */
public class LCD1 {

	public static void main(String[] args) {
		LCD.drawString("LCD1", 0, 0);
	    Button.waitForAnyPress();
	    
	    LCD.drawString("Free RAM:", 0, 0);
	    LCD.drawInt((int) System.getRuntime().freeMemory(), 6, 9, 0);
	    Button.waitForAnyPress();
	}

}
