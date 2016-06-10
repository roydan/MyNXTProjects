package com.lejos.debugtutor;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ListenersAndEvents/Listeners_Events.htm
 * LEJOS Java for LEGO Mindstorms
 * Error Handling and Debugging
 * Exceptions
 */
public class ExceptionTutor1
{
	static void m1()
	{
	    int test[] = new int[2];
	    // Force an exception
	    test[0] = test[1] + test[2]; // This is line 6
	}

	static void m2()
	{
	    m1();
	}

	public static void main (String[] args) throws Exception
	{
		System.out.println("Running");
	    m2();
	}
}
