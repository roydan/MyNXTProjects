package com.lejos.vehicletutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/WheeledVehicles/WheeledVehicles.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling Wheeled Vehicles
 * Program SquareTracer
 * 
 * program that uses a DifferentialPilot to trace out a square,
 * using the travel and void rotate(double degrees) methods
 */
public class SquareTracer {
	DifferentialPilot pilot;
	static double wheelDiameter = 3.5;	// 3.0 wheel / 3.5 wheel + chenille
	static double trackWidth = 17.7;	// 12.9 center-center / 9.4 front-rear / 16.0 = hypothenuse

	public void drawSquare() {
		double distance = 10 * wheelDiameter;
		for (int i=1; i<=4; i++) {
			pilot.travel(distance);
			pilot.rotate(90);
		}
	    Button.waitForAnyPress();
	}

	public static void main(String[] args) {
		LCD.drawString("SquareTracer", 0, 0);
		SquareTracer traveler = new SquareTracer();
	    traveler.pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.B, Motor.C);
	    Button.waitForAnyPress();
	    traveler.drawSquare();
	}
}
