package com.lejos.motortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;

/*
 * http://www.lejos.org/nxt/nxj/tutorial/MotorTutorial/ControllingMotors.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling the Motors
 * Program 3 - Accurate rotation control
 * 
 * Display the program name and wait for a button press
 * Rotate the motor 4 complete revolutions
 * Display the tachometer reading on the on the LCD
 * Rotate the motor to angle 0
 * Display the tachometer reading on the on the LCD, next row
 * Wait for a button press
 */
public class MotorTutor3 {

	public static void main(String[] args) {
		LCD.drawString("Motor Tutor 3", 0, 0);

        Button.waitForAnyPress();
		
        Motor.A.rotate(4 * 360);	// rotate 4 complete revolutions
        
		LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
		
        Motor.A.rotateTo(0);

		LCD.drawInt(Motor.A.getTachoCount(), 0, 2);
		
        Button.waitForAnyPress();
	}

}
