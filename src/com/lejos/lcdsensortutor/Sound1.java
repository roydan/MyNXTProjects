package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Sound
 * 
 * As a graphics display, the NXT LCD screen is 100 pixels wide and 64 pixels deep.
 * It is addressed using (x, y) pixel co-ordinates:
 * x ranges from 0 to 99 (left to right),
 * and y from 0 to 63 (from top to bottom).
 */
public class Sound1 {

	private static final int[] note = {
			// freq, duration
			2349, 115,
			0, 5,
			1760, 165,
			0, 35};
	
	public static void main(String[] args) throws Exception {
		LCD.drawString("Sound1", 0, 0);
	    Button.waitForAnyPress();
		LCD.clear();
	    
		for (int i = 0; i < note.length; i += 2) {
			int w = note[i+1];
			int n = note[i];
			if (n != 0) {
				Sound.playTone(n, w * 10);
			}
			Thread.sleep(w * 10);
		}
	    Button.waitForAnyPress();
	    
		for (int i = 0; i <= 4; i++) {
			LCD.clear();
			LCD.drawString("sound: " + i, 0, 0);
			Sound.systemSound(true, i);
			Thread.sleep(2000);
		}
	    Button.waitForAnyPress();
	}

}
