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
 * Program SteerTester
 * 
 * Traveling in a circular path
 * 
 * DifferentialPilot can also control the robot to move in a circular path using these methods:
 * 
 * void steer(double turnRate) – follows a circular path until another method is executed
 * void steer(double turnRate, int angle)
 * void steer(double turnRate, int angle, boolean immediateReturn)
 * 
 * The turnRate parameter determines the radius of the path.
 * A positive value means that center of the circle is to the left of the robot
 * (so the left motor drives the inside wheel).
 * A negative value means the left motor drives the outside wheel.
 * The absolute value is between 0 and 200,
 * and this determines the ratio of inside to outside motor speed.
 * The outside motor runs at the set speed of the robot;
 * the inner motor is slowed down to make the robot turn.
 * At turn rate 0, the speed ratio is 1.0 and the robot travels in a straight line.
 * At turn rate 200, the speed ratio is -1 and the robot turns in place.
 * Turn rate 100 gives speed ratio 0, so the inside motor stops.
 * The formula is: speed ratio = 100 - abs(turnRate).
 * 
 * The angle parameter determines the rotation angle at which the robot stops.
 * If the angle is negative, the robot follows the circular path
 * with the center defined by the turn rate, but it moves backwards.
 * 
 * program that uses the ButtonCounter to enter the turn rate and angle variables,
 * and then calls the steer() method.
 * It does this in a loop so you can try different values of these parameters
 * to control the robot path.
 */
public class SteerTester2 {
	DifferentialPilot pilot;
	static double wheelDiameter = 3.5;	// 3.0 wheel / 3.5 wheel + chenille
	static double trackWidth = 17.6;	// 12.9 center-center / 9.4 front-rear / 16.0 = hypothenuse
	TouchSensor bump = new TouchSensor(SensorPort.S1);

	public double convertNbDigits (double value, int nbDigits) {
		double mult = Math.pow(10., nbDigits);
		return (double)((int)(value * mult)) / mult;
	}
	
	public double convert (float value, int nbDigits) {
		return (float)convertNbDigits(value, nbDigits);
	}
	
	public void steerDemo() {
		// The turnRate parameter determines the radius of the path.
		// The absolute value is between 0 and 200,
		// and this determines the ratio of inside to outside motor speed.
		// The outside motor runs at the set speed of the robot;
		// the inner motor is slowed down to make the robot turn.
		// The formula is: speed ratio = 100 - abs(turnRate).
		
		// A positive value means the left motor drives the inside wheel: robot turns to the left
		// (so the left motor drives the inside wheel).
		pilot.steer(50, 180, true); 	// turn 180 degrees to the left
		Motor.B.waitComplete();         // returns when previous method is complete
		Motor.C.waitComplete();         // returns when previous method is complete
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
		
		// A negative value means the left motor drives the outside wheel: robot turns to the right
		pilot.steer(-50, 180, true); 	// turn 180 degrees to the right
	    while (pilot.isMoving());
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
		
		// At turn rate 0, the speed ratio is 1.0 and the robot travels in a straight line.
		pilot.steer(0, 180, true);		// robot travels in a straight line
	    while (pilot.isMoving()) {
	    	if (bump.isPressed()) pilot.stop();
	    }
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
	    
		// At turn rate 200, the speed ratio is -1 and the robot turns in place.
		pilot.steer(200, 180, true); 	// robot turns in place
	    while (pilot.isMoving());
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
		
		// Turn rate 100 gives speed ratio 0, so the inside motor stops.
		pilot.steer(100, 180, true);	// turns with left wheel stationary
	    while (pilot.isMoving());
	    System.out.println("traveled= " + convertNbDigits(pilot.getMovement().getDistanceTraveled(), 2));
	    Button.waitForAnyPress();
	}

	public static void main(String[] args) {
		LCD.drawString("Steer Tester 2", 0, 0);
		SteerTester2 myPilot = new SteerTester2();
		myPilot.pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.B, Motor.C);
	    Button.waitForAnyPress();
	    
	    myPilot.steerDemo();
	}
}
