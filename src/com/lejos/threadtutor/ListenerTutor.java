package com.lejos.threadtutor;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LCD;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ListenersAndEvents/Listeners_Events.htm
 * LEJOS Java for LEGO Mindstorms
 * Threads, Listeners and Events
 * Listeners and Events
 */
public class ListenerTutor
{
	public static void main(String[] args)
	{
		Button.ENTER.addButtonListener(new ButtonListener()
		{
			public void buttonPressed(Button b) {
		    	LCD.clear();
		        LCD.drawString("ENTER pressed", 0, 0);
		    }

		    public void buttonReleased(Button b) {
		    	LCD.clear();
		    }
		});

		LCD.drawString("ListenerTutor", 0, 0);
		Button.ESCAPE.waitForPressAndRelease();
	}
}
