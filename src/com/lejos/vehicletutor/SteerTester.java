package com.lejos.vehicletutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.ButtonCounter;

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
 * 
 * Left button enters  100's digit, right - 10's digit
 */
public class SteerTester
{
	static double wheelDiameter = 3.5;	// 3.0 wheel / 3.5 wheel + chenille
	static double trackWidth = 17.6;	// 12.9 center-center / 9.4 front-rear / 16.0 = hypothenuse

	public static void main(String[] args)
	{
		LCD.drawString("Steer Tester", 0, 0);
		DifferentialPilot pilot = new DifferentialPilot(wheelDiameter, trackWidth, Motor.B, Motor.C);
	    Button.waitForAnyPress();
	    
	    ButtonCounter bc = new ButtonCounter();
        while (true)
        {
            bc.count("Turn Rate x10");
            int turnRate = 100 * bc.getLeftCount() + 10 * bc.getRightCount();
            bc.count("Angle x 10");
            int angle = 100 * bc.getLeftCount() + 10 * bc.getRightCount();
            if ((turnRate != 0) && (angle != 0)) {
            	pilot.steer(turnRate, angle);
            } else {
            	break;
            }
        }
	}
}
