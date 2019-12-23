package programming.set1.getting_started;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * Displays a quote from "The Big Lebowski".
 */
public class HelloProgram extends GraphicsProgram {

	public void run() {
		// Construct and add a GLabel to the canvas at the coordinates (100, 75)
		add(new GLabel("Careful man, there's a beverage here!"), 100, 75);
	}

	public static void main(String[] args) {
		new HelloProgram().start();
	}

}
