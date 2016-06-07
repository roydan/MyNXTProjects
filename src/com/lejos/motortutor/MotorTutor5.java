package com.lejos.motortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

/*
 * http://www.lejos.org/nxt/nxj/tutorial/MotorTutorial/ControllingMotors.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling the Motors
 * Program 5 - Regulating motor speed
 * 
 * Display the program name
 * Set the speed of all 3 motors at 2 revolutions/sec
 * Start all 3 motors rotating through 2 revolutions simultaneously
 * Every 200 ms, display all 3 tacho count values in a row
 * Repeat step 3, 8 times, using a different row each time
 * Wait for a button press while you write down the array of numbers (perhaps in a spread sheet)
 */
public class MotorTutor5 {

	public static void main(String[] args) {
		LCD.drawString("Motor Tutor 5", 0, 0);

        Button.waitForAnyPress();
		
        int speed = 720;				// 720 deg/sec = 2 RPS = 120 RPM
        Motor.A.setSpeed(speed);
        Motor.B.setSpeed(speed);
        Motor.C.setSpeed(speed);
        
        int angle = 2 * 360;			// 2 revolutions
        Motor.A.rotate(angle, true);
        Motor.B.rotate(angle, true);
        Motor.C.rotate(angle, true);

        for (int i = 1; i <= 8; i++) {
            Delay.msDelay(200);
        	LCD.drawInt(Motor.A.getTachoCount(), 0, i);
        	LCD.drawInt(Motor.B.getTachoCount(), 6, i);
        	LCD.drawInt(Motor.C.getTachoCount(), 12, i);
        }
        
        while (Motor.A.isMoving() || Motor.B.isMoving() || Motor.C.isMoving());
        
        Button.waitForAnyPress();
	}

}
