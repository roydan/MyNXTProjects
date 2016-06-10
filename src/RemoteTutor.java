import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.RConsole;

/**
 * http://www.lejos.org/nxt/nxj/tutorial/ListenersAndEvents/Listeners_Events.htm
 * LEJOS Java for LEGO Mindstorms
 * Error Handling and Debugging
 * Remote Debugging
 * 
 * use default package
 */
public class RemoteTutor {

	public static void main(String[] args) {
		LCD.drawString("RemoteTutor", 0, 0);
	    Button.waitForAnyPress();
	    
		RConsole.open();		// run nxjconsole on terminal window
	    Button.waitForAnyPress();
	    
	    RConsole.println("Start for loop ");
	    for (int i = 0; i < 5; i++) {
	    	RConsole.print(" " + i);
	    	LCD.drawInt(i, 2, 2 * i, 4);
	    }
	    RConsole.println("\n done ");
	    RConsole.close();
	    Button.waitForAnyPress();
	}

}
