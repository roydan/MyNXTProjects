package com.lejos.motortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/*
 * http://www.lejos.org/nxt/nxj/tutorial/MotorTutorial/ControllingMotors.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling the Motors
 * Program 4 - Interrupting rotation
 * 
 * Display the program name
 * Start a rotation of 4 revolutions backward
 * While the motor is rotating, display the tacho count
 * When a button is pressed, stop the motor
 * After the motor has stopped, display the tacho count in another row
 * Wait for a button press
 */
public class MotorTutor4 {

	public static void main(String[] args) {
		LCD.drawString("Motor Tutor 4", 0, 0);

        Button.waitForAnyPress();
		
        Motor.A.rotate(-4 * 360, true);		// rotate 4 revolutions backward

        while (Motor.A.isMoving()) {
            Delay.msDelay(200);				// add small delay (200 ms)
        	LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
            if (Button.readButtons() > 0) Motor.A.stop();
        }
        
		LCD.drawInt(Motor.A.getTachoCount(), 0, 2);
		
        Button.waitForAnyPress();
	}

}
