package com.lejos.behaviortutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/Behaviors/BehaviorProgramming.htm
 * LEJOS Java for LEGO Mindstorms
 * Behavior programming
 * Programming Behavior with leJOS NXJ
 * 
 * program some behavior for a simple robot with differential steering.
 * This robot will drive forward as its primary low-level behavior.
 * This activity continues unless the robot hits an object,
 * then a high priority behavior will become active to back the robot up and turn it 90 degrees
 * 
 */

class DriveForward implements Behavior {
	private boolean suppressed = false;
	   
	public boolean takeControl() {
	    return true;
	}

	public void suppress() {
	    suppressed = true;
	}

	public void action() {
		suppressed = false;
	    Motor.B.forward();
	    Motor.C.forward();
	    while (!suppressed) {
	    	Thread.yield();
	    }
	    Motor.B.stop(); // clean up
	    Motor.C.stop();
	}
}

class HitWall implements Behavior {
	private TouchSensor touch = null;
    private UltrasonicSensor sonar =  null;
    private boolean suppressed = false;
    
    public HitWall(SensorPort touchPort, SensorPort sonarPort)
    {
    	touch = new TouchSensor(touchPort);
    	sonar = new UltrasonicSensor(sonarPort);
    }

    public HitWall(SensorPort sonarPort)
    {
    	sonar = new UltrasonicSensor(sonarPort);
    }

    public boolean takeControl() {
    	if (touch != null) {
    		return (touch.isPressed() || (sonar.getDistance() < 25));
    	} else {
        	return (sonar.getDistance() < 25);
    	}
    }

    public void suppress() {
       suppressed = true;
    }

    public void action() {
    	suppressed = false;
    	Motor.B.rotate(-180, true);
    	Motor.C.rotate(-360, true);

    	while (Motor.C.isMoving() && !suppressed) {
    		Thread.yield();
    	}

    	Motor.B.stop();
    	Motor.C.stop();
    }
}

class HitTouch implements Behavior {
	private TouchSensor touch;
    private boolean suppressed = false;
    
    public HitTouch(SensorPort touchPort)
    {
    	touch = new TouchSensor(touchPort);
    }

    public boolean takeControl() {
    	return touch.isPressed();
    }

    public void suppress() {
       suppressed = true;
    }

    public void action() {
    	suppressed = false;
    	Motor.B.stop();
    	Motor.C.stop();
    	System.exit(0);
    }
}

public class BumperCar
{
	public static void main(String[] args) {
		LCD.drawString("BumperCar", 0, 0);
	    Button.waitForAnyPress();
	    
		Behavior b1 = new DriveForward();
	    Behavior b2 = new HitWall(SensorPort.S4);
	    Behavior b3 = new HitTouch(SensorPort.S1);
	    Behavior [] bArray = {b1, b2, b3};
	    Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
}
