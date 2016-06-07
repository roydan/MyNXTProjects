package com.lejos.motortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/*
 * http://www.lejos.org/nxt/nxj/tutorial/MotorTutorial/ControllingMotors.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling the Motors
 * Program 2 - Using the Tachometer
 * 
 * Display the program number
 * Set the motor speed to 2 rev/sec
 * Run Motor.A forward
 * Wait for 2 seconds
 * Display the motor angle on the LCD. (what should it be?)
 * Stop the motor
 * Display the tachometer reading on the on the next line LCD
 * Start the motor rotating backward
 * Wait till the tacho count reaches 0
 * Display the tacho count on the next line
 * Stop the motor
 * Display the tacho count on the next line
 * Wait for a button press so you can read the LCD
 */
public class MotorTutor2 {

	public static void main(String[] args) {
		LCD.drawString("Motor Tutor 2", 0, 0);

        Button.waitForAnyPress();
		
        Motor.A.setSpeed(720);		// 720 deg/sec = 2 RPS = 120 RPM
        
        Motor.A.forward();
		
        Delay.msDelay(2000);		// 2 seconds (in ms)
        
		LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
		
        Motor.A.stop();

		LCD.drawInt(Motor.A.getTachoCount(), 0, 2);
		
        Motor.A.backward();

        while (Motor.A.getTachoCount() > 0);

		LCD.drawInt(Motor.A.getTachoCount(), 0, 3);
		
        Motor.A.stop();

		LCD.drawInt(Motor.A.getTachoCount(), 0, 4);
		
        Button.waitForAnyPress();
	}

}
