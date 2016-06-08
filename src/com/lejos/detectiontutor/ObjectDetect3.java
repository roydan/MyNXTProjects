package com.lejos.detectiontutor;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.FusorDetector;
import lejos.robotics.objectdetection.RangeFeatureDetector;
import lejos.robotics.objectdetection.TouchFeatureDetector;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ObjectDetection/ObjectDetection.htm
 * LEJOS Java for LEGO Mindstorms
 * Object Detection
 * Multiple Feature Detectors
 */
public class ObjectDetect3 implements FeatureListener {

	public static int MAX_DISTANCE = 30;	// In centimeters
	public static int DELAY = 500;			// In milliseconds

	public static void main(String[] args) {
		System.out.println("ObjectDetect3");
	    Button.waitForAnyPress();
		
	    ObjectDetect3 listener = new ObjectDetect3();
		
		UltrasonicSensor sensor1 = new UltrasonicSensor(SensorPort.S4);
		RangeFeatureDetector detector1 = new RangeFeatureDetector(sensor1, MAX_DISTANCE, DELAY);
		
		TouchSensor sensor2 = new TouchSensor(SensorPort.S1);
		TouchFeatureDetector detector2 = new TouchFeatureDetector(sensor2);
		
		FusorDetector fusion = new FusorDetector();
		fusion.addDetector(detector1);
		fusion.addDetector(detector2);
		
		fusion.addListener(listener);
		
	    Button.waitForAnyPress();
	}
	
	@Override
	public void featureDetected(Feature feature, FeatureDetector detector) {
		LCD.clear();
		if (detector instanceof FusorDetector)
		{
			System.out.println("type: Fusor");
			boolean isInvalid = feature.getRangeReading().invalidReading();
			float range = feature.getRangeReading().getRange();
			float angle = feature.getRangeReading().getAngle();
			long timestamp = feature.getTimeStamp();
			System.out.println("valid: " + !isInvalid);
			System.out.println("range: " + range);
			System.out.println("angle: " + angle);
			System.out.println("time: " + timestamp);
		}
		else if (detector instanceof RangeFeatureDetector)
		{
			System.out.println("type: Range");
			boolean isInvalid = feature.getRangeReading().invalidReading();
			float range = feature.getRangeReading().getRange();
			float angle = feature.getRangeReading().getAngle();
			long timestamp = feature.getTimeStamp();
			System.out.println("valid: " + !isInvalid);
			System.out.println("range: " + range);
			System.out.println("angle: " + angle);
			System.out.println("time: " + timestamp);
		}
		else if (detector instanceof TouchFeatureDetector)
		{
			System.out.println("type: Touch");
			boolean isInvalid = feature.getRangeReading().invalidReading();
			float range = feature.getRangeReading().getRange();
			float angle = feature.getRangeReading().getAngle();
			long timestamp = feature.getTimeStamp();
			System.out.println("valid: " + !isInvalid);
			System.out.println("range: " + range);
			System.out.println("angle: " + angle);
			System.out.println("time: " + timestamp);
		}
	}
}
