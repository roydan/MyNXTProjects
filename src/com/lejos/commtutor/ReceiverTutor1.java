package com.lejos.commtutor;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.LCPBTResponder;
import lejos.nxt.comm.NXTConnection;
import lejos.nxt.comm.USB;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/Communications/Communications.htm
 * LEJOS Java for LEGO Mindstorms
 * Communications
 * Receiver
 */
public class ReceiverTutor1
{
	public static void main(String[] args) throws Exception
	{
		LCD.drawString("ReceiverTutor1", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		LCD.drawString("right BT", 0, 0);
	    NXTConnection connection = null;

		LCD.clear();
	    if (Button.waitForAnyPress() == Button.ID_RIGHT) {
	    	LCD.drawString("waiting for BT", 0, 1);
	    	connection = Bluetooth.waitForConnection();
	    } else {
	    	LCD.drawString("waiting for USB", 0, 1);
	    	connection = USB.waitForConnection();
	    }

	    DataOutputStream dataOut = connection.openDataOutputStream();
	    try {
	    	dataOut.writeInt(1234);
	    } catch (IOException e) {
	    	System.out.println("write error " + e); 
	    }
	}
}
