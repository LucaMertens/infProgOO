package programming.set1.geometry;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * Asks for a number n and constructs a Polygon with n corners.
 */
public class Polygon extends GraphicsProgram {

	public void run() {
		/*
		 * Ask the user to enter the number of corners. The last two arguments limit the
		 * range of possible integers, because at least 3 corners are needed to
		 * construct a Polygon.
		 */
		int n = readInt("Enter the number of corners: ", 3, Integer.MAX_VALUE);

		// This "variable" will not change within a Polygon-Object, so there's no need
		// to
		// recalculate it every time it's used. It can be stored as a final.
		final double inscribedAngle = 2 * Math.PI / n;
		// Initialize the radius of the Polygon for later calculations.
		final int radius = 100;
		// These variables could be used to position the polygon in the canvas.
		// Right now, they are set to the radius to ensure that the Polygon is fully
		// visible.
		final int centerX = radius;
		final int centerY = radius;

		// Start a loop that will execute the inner code n times.
		for (int i = 0; i < n; i++) {
			// Calculate the first point to construct the nth side of the Polygon.
			double x1 = centerX + radius * Math.cos(i * inscribedAngle);
			double y1 = centerY + radius * Math.sin(i * inscribedAngle);
			// Calculate the second point to construct the nth side of the Polygon.
			double x2 = centerX + radius * Math.cos((i + 1) * inscribedAngle);
			double y2 = centerY + radius * Math.sin((i + 1) * inscribedAngle);

			// Construct the Line and add it to the canvas.
			add(new GLine(x1, y1, x2, y2));
		}
	}

	public static void main(String[] args) {
		new Polygon().start();
	}

}
