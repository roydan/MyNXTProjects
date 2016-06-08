package com.lejos.detectiontutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.RangeFeatureDetector;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ObjectDetection/ObjectDetection.htm
 * LEJOS Java for LEGO Mindstorms
 * Object Detection
 * Feature Detectors
 */
public class ObjectDetect1 {

	public static void main(String[] args) {
		LCD.drawString("ObjectDetect1", 0, 0);
	    Button.waitForAnyPress();
		LCD.clear();
		
		// simple RangeFeatureDetector - uses RangeFinder classes, such as the LEGO UltrasonicSensor
		int MAX_DISTANCE = 50;	// In centimeters
		int DELAY = 500;		// In milliseconds
		UltrasonicSensor rf = new UltrasonicSensor(SensorPort.S4);
		//?? RangeFinder rf = new UltrasonicSensor(SensorPort.S4);
		RangeFeatureDetector rfd = new RangeFeatureDetector(rf, MAX_DISTANCE, DELAY);

		Feature result = rfd.scan();
		if (result != null) {
			System.out.println("Range: " + result.getRangeReading().getRange());
		} else {
			System.out.println("Range: null");
		}
		
	    Button.waitForAnyPress();
	}
}
