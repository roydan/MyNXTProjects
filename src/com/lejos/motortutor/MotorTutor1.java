package com.lejos.motortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

/*
 * http://www.lejos.org/nxt/nxj/tutorial/MotorTutorial/ControllingMotors.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling the Motors
 * Program 1 - Basic movement controls
 * 
 * Display "Program 1 " in row 0 of the LCD
 * Wait for a button to be pressed
 * Run motor A in the forward direction
 * Display FORWARD in the top line
 * Wait until a button is pressed
 * Run the motor backward
 * Display BACKWARD in next line
 * Wait until a button is pressed
 * Stop the motor
 */
public class MotorTutor1 {

	public static void main(String[] args) {
		LCD.drawString("Program 1", 0, 0);

        Button.waitForAnyPress();
		
        Motor.A.forward();
		
		LCD.clear();
		LCD.drawString("FORWARD", 0, 0);
		
        Button.waitForAnyPress();
		
        Motor.A.stop();
        Motor.A.backward();
		
		LCD.drawString("BACKWARD", 0, 1);
		
        Button.waitForAnyPress();
		
        Motor.A.stop();
	}

}
