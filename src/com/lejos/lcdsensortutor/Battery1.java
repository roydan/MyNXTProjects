package com.lejos.lcdsensortutor;

import lejos.nxt.Battery;
import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Battery
 */
public class Battery1 {

	public static void main(String[] args) {
		LCD.drawString("Battery1", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		LCD.drawString("Batt(V): " + Battery.getVoltage(), 0, 0);
	    Button.waitForAnyPress();

		LCD.clear();
		LCD.drawString("Batt(mV): " + Battery.getVoltageMilliVolt(), 0, 0);
	    Button.waitForAnyPress();
	}

}
