package com.lejos.filetutor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/AdvancedTopics/UnderstandingFilesLCPMemTools.htm
 * LEJOS Java for LEGO Mindstorms
 * Advanced Topics: Files, LCP, Memory, NXJ Tools
 * Understanding the leJOS File System
 * 
 */
public class FileTutor1
{
	public static void main(String[] args)
	{
		LCD.drawString("FileTutor1", 0, 0);
	    Button.waitForAnyPress();
	    
		LCD.clear();
		
		FileOutputStream out = null; // declare outside the try block
	    File data = new File("log.dat");

	    try {
	    	out = new FileOutputStream(data);
	    } catch(IOException e) {
	    	System.err.println("Failed to create output stream");
	    	Button.waitForAnyPress();
	    	System.exit(1);
	    }

	    DataOutputStream dataOut = new DataOutputStream(out);

	    float x = 1f;
	    int length = 4;

	    try {
	    	// write
	    	for (int i = 0 ; i < length; i++) {
		        dataOut.writeFloat(x);
		    	System.out.println("" + x);
		        x *= -2.2f;
	    	}
	    	out.flush();
	    	out.close();	// flush the buffer and write the file
	    } catch (IOException e) {
	    	System.err.println("Failed to write to output stream");
	    	Button.waitForAnyPress();
	    	System.exit(1);
	    }
	    
	    Sound.beep();
    	System.out.println("write OK");
	    Button.waitForAnyPress();
	    
	    try {
	        InputStream is = new FileInputStream(data);
	        DataInputStream din = new DataInputStream(is);

	        while (is.available() > 3) { // at least 4 bytes left to read
	          float xin = din.readFloat();

	          System.out.println("" + xin);
	        }
	        din.close();
	      } catch (IOException ioe) {
	        System.err.println("Read Exception");
	    	Button.waitForAnyPress();
	    	System.exit(1);
	      }
	    
	    Sound.beep();
    	System.out.println("read OK");
	    Button.waitForAnyPress();
	}
}
