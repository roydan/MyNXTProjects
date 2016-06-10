package com.lejos.threadtutor;

import lejos.nxt.Battery;
import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ListenersAndEvents/Listeners_Events.htm
 * LEJOS Java for LEGO Mindstorms
 * Threads, Listeners and Events
 * Java Threads
 */
class Indicators extends Thread {
	private boolean io = false;
    private int ioIndex = 0;

	public void setIoActive(boolean value) {
		io = value;
	    ioIndex = 0;
	}

	public void run() {
	    String[] ioProgress = { ".   ", " .  ", "  . " };
	    while (true) {
	    	try {
	        	LCD.drawString("    ", 12, 0);
	        	LCD.drawInt(Battery.getVoltageMilliVolt(), 12, 0);
	        	LCD.refresh();
	        	
    			LCD.drawString("    ", 8, 0);
	    		if (io) {
			        ioIndex %= ioProgress.length;
			        LCD.drawString(ioProgress[ioIndex++], 8, 0);
		        	LCD.refresh();
		        }
		        Thread.sleep(1000);
	      } catch (InterruptedException ie) {
	      }
	    }
	}
}

public class ThreadTutor {

	public static void main(String[] args) {
		LCD.drawString("ThreadTutor", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		Indicators ind = new Indicators();
		ind.setDaemon(true);
		ind.start();
	    Button.waitForAnyPress();
	    
	    ind.setIoActive(true);
	    Button.waitForAnyPress();
	    
	    ind.setIoActive(false);
	    Button.waitForAnyPress();
	}

}
