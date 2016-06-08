package com.lejos.lcdsensortutor;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm
 * LEJOS Java for LEGO Mindstorms
 * Hardware: I/O and Sensors
 * Color Sensor
 */
public class ColorSensor1
{
	private static final int[] colorFL = { 0, 1, 2 };	// REED, GREEN, BLUE

	public static void main(String[] args)  throws Exception
	{
		LCD.drawString("ColorSensor1", 0, 0);
	    Button.waitForAnyPress();
	    
	    ColorSensor sensor1 = new ColorSensor(SensorPort.S2);

		LCD.clear();
	    sensor1.setFloodlight(true);
	    System.out.println("Floodlight: " + sensor1.isFloodlightOn());
	    Button.waitForAnyPress();
	    
	    sensor1.setFloodlight(false);
	    System.out.println("Floodlight: " + sensor1.isFloodlightOn());
	    Button.waitForAnyPress();
	    
		LCD.clear();
	    for (int i = 0; i < colorFL.length; i++) {
		    sensor1.setFloodlight(colorFL[i]);
	    	LCD.drawInt(sensor1.getFloodlight(), 4, 0, 0);
	    	Thread.sleep(2000);
	    }
	    Button.waitForAnyPress();

	    sensor1.setFloodlight(false);
	    
		LCD.clear();
	    do {
	    	LCD.drawInt(sensor1.getColorID(), 4, 0, 0);
	    	LCD.drawInt(sensor1.getLightValue(), 4, 0, 1);
	    	LCD.drawInt(sensor1.getNormalizedLightValue(), 4, 0, 2);
	    	Thread.sleep(1000);
	    } while (Button.readButtons() == 0);
	    
	    Button.waitForAnyPress();
	}
}
