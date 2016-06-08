package com.lejos.vehicletutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/WheeledVehicles/WheeledVehicles.htm
 * LEJOS Java for LEGO Mindstorms
 * Controlling Wheeled Vehicles
 * Program TravelTest - DifferentialPilot Example
 * 
 * Robot that stops if it hits something before it completes its travel
 */
public class TravelTest {
	DifferentialPilot pilot;
	TouchSensor bump = new TouchSensor(SensorPort.S1);
	static double wheelDiameter = 3.0;

	public double convertNbDigits (double value, int nbDigits) {
		double mult = Math.pow(10., nbDigits);
		return (double)((int)(value * mult)) / mult;
	}
	
	public double convert (float value, int nbDigits) {
		float mult = (float)Math.pow(10., nbDigits);
		return (float)((int)(value * mult)) / mult;
	}
	
	public void go() {
		double travelTarget = 50 * wheelDiameter;
		pilot.travel(travelTarget, true);
	    while (pilot.isMoving()) {
	    	if (bump.isPressed()) pilot.stop();
	    }
	    System.out.println("target=   " + convertNbDigits(travelTarget, 2));
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
	}

	public static void main(String[] args) {
		LCD.drawString("TravelTest", 0, 0);
		TravelTest myPilot = new TravelTest();
		myPilot.pilot = new DifferentialPilot(wheelDiameter, 12.8, Motor.B, Motor.C);
	    Button.waitForAnyPress();
	    myPilot.go();
	}
}
