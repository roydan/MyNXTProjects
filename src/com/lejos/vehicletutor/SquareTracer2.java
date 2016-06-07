package com.lejos.vehicletutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/WheeledVehicles/WheeledVehicles.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling Wheeled Vehicles
 * Program SquareTracer2
 * 
 * program that traces 2 squares with increasing angle at the corners,
 * then retraces the same path in the opposite direction.
 * Modify the traceSquare method of program DifferentialPilot 1
 *  so it can trace a square in either direction, and use it in this program.
 *  This is stringent test of the accuracy of the wheel diameter and
 *  track width constants you use in you pilot.
 */
public class SquareTracer2 {
	DifferentialPilot pilot;
	static double wheelDiameter = 3.5;	// 3.0 wheel / 3.5 wheel + chenille
	static double trackWidth = 17.7;	// 12.9 center-center / 9.4 front-rear / 16.0 = hypothenuse

	public void drawSquare(int direction, double distance) {
		double angle = 90;
		for (int i = 1; i <= 4; i++) {
			if (direction == 1) {
				pilot.travel(direction * distance);
				pilot.rotate(direction * angle);
			} else {
				pilot.rotate(direction * angle);
				pilot.travel(direction * distance);
			}
		}
	}

	public static void main(String[] args) {
		LCD.drawString("Square Tracer 2", 0, 0);
		SquareTracer2 traveler = new SquareTracer2();
	    traveler.pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.B, Motor.C);
	    Button.waitForAnyPress();
		double distance = 10. * wheelDiameter;
		for (int j = 1; j <= 2; j++) {
		    traveler.drawSquare(1, distance);
		}
		for (int j = 1; j <= 2; j++) {
		    traveler.drawSquare(-1, distance);
		}
	    Button.waitForAnyPress();
	}
}
