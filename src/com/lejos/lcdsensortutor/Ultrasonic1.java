package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Ultrasonic Sensor
 */
public class Ultrasonic1
{
	public static void main(String[] args) throws Exception
	{
		LCD.drawString("Ultrasonic1", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);

	    do {
	    	LCD.clear();
	    	LCD.drawString(sonic.getVendorID(), 0, 0);
	    	LCD.drawString(sonic.getProductID(), 0, 1);
	    	LCD.drawString(sonic.getVersion(), 0, 2);
	    	LCD.drawInt(sonic.getDistance(), 0, 3);
	    	Thread.sleep(1000);
	    } while (Button.readButtons() == 0);
	}
}
