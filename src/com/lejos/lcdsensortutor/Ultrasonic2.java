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
 * 
 * Program: multiple echoes
 * *
 * program that displays the distances from multiple echoes in a column.
 * The program should make four calls to ping(),
 * and display the four columns of results,
 * then wait for a button press.
 * Exit if the ESCAPE button was pressed.
 */
public class Ultrasonic2 {
	
	public static void main(String[] args) throws Exception
	{
		LCD.drawString("Ultrasonic2", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
		int[] distances = new int[8];

	    do {
			LCD.clear();
			for (int j = 0; j < 4; j++) {
				sonic.ping();
				sonic.getDistances(distances);
				Thread.sleep(30);
				for (int i = 0; i < distances.length; i++) {
					LCD.drawInt(distances[i], i*3, j);
				}
			}			
		    Button.waitForAnyPress();
	    } while (!Button.ESCAPE.isDown());
	    
		sonic.continuous();
	}
}
