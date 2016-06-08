package com.lejos.lcdsensortutor;

import javax.microedition.lcdui.Graphics;

import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * LCD Graphics methods
 * 
 * As a graphics display, the NXT LCD screen is 100 pixels wide and 64 pixels deep.
 * It is addressed using (x, y) pixel co-ordinates:
 * x ranges from 0 to 99 (left to right),
 * and y from 0 to 63 (from top to bottom).
 */
public class LCD2 {

	public static void main(String[] args) {
		LCD.drawString("LCD2", 0, 0);
	    Button.waitForAnyPress();
		LCD.clear();
	    
	    Graphics g = new Graphics();
	    g.drawLine(5,5,60,60);
	    g.drawRect(62, 10, 25, 35);
	    Button.waitForAnyPress();
	}

}
