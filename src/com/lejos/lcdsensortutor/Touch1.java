package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Touch Sensor
 */
public class Touch1
{
	public static void main(String[] args)
	{
		LCD.drawString("Touch1", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		TouchSensor touch = new TouchSensor(SensorPort.S1);
	    while (!touch.isPressed());
	    LCD.drawString("Finished", 0, 0);
	    Button.waitForAnyPress();
	}
}
