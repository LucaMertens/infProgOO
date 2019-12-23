package programming.set2.shapes;

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * A 6-colored rainbow in front of a blue sky and a verdant field.
 */
public class Rainbow extends GraphicsProgram {
	/**
	 * An array containing every color the rainbow's gonna have, sorted from outer
	 * to inner layer. These truly are ♫ The colors of the rainbow ♫, but Pink got
	 * stolen.
	 */
	static final Color[] COLORS_OF_THE_RAINBOW = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE,
			new Color(128, 0, 128) };
	/**
	 * The color. The color for the sky. The color chosen especially for the sky.
	 * The sky's color.
	 */
	static final Color SKY_COLOR = new Color(0, 153, 255);

	/**
	 * The x and y coordinates of the outer rectangle the rainbow is inscribed in.
	 */
	private double x, y;
	/**
	 * The width of the rainbow's frame rectangle. Depending on how the rainbow is
	 * rotated, this migth differ from the visible width of the rainbow.
	 */
	private double totalWidth;
	/**
	 * The height of the rainbow's frame rectangle. This won't be the actual height
	 * of the rainbow most of the time.
	 */
	private double totalHeight;
	/**
	 * The angle at which the Rainbow begins measured in degrees counterclockwise
	 * from the +x axis.
	 */
	private double start;
	/**
	 * The extent of the Rainbow, measured in degrees counterclockwise.
	 */
	private double sweep;

	/**
	 * Creates a rainbow object with some standart values (for testing).
	 */
	Rainbow() {
		this(0, 0, 300, 300, 0, 180);
	}

	/**
	 * Creates a (more or less) beautiful rainbow (object). Yay!
	 * 
	 * The parameters are the same as for the GArc class, which is why the following
	 * parameter-infos are copied from the GArc documentation.
	 * 
	 * @param x           The x-coordinate for the rectangle in which the Rainbow is
	 *                    inscribed
	 * @param y           The y-coordinate for the rectangle in which the Rainbow is
	 *                    inscribed
	 * @param totalWidth  The width of the rectangle in which the Rainbow is
	 *                    inscribed.
	 * @param totalHeight The height of the rectangle in which the Rainbow is
	 *                    inscribed. The height will always be measured across the
	 *                    whole oval the rainbow is a part of!!!
	 * @param start       The angle at which the Rainbow begins measured in degrees
	 *                    counterclockwise from the +x axis
	 * @param sweep       The extent of the Rainbow, measured in degrees
	 *                    counterclockwise
	 */
	Rainbow(double x, double y, double totalWidth, double totalHeight, double start, double sweep) {
		this.x = x;
		this.y = y;
		this.totalWidth = totalWidth;
		this.totalHeight = totalHeight;
		this.start = start;
		this.sweep = sweep;
	}

	@Override
	public void run() {
		// Add a sky to our rainbow so that it's not lonely. (This will be painted
		// first).
		int margin = 50;
		double skyWidth = totalWidth + margin;
		double skyHeight = totalHeight + margin;
		addSky(skyWidth, skyHeight);

		// This variable defines how large the gap under the rainbow is going to be in
		// comparison to its stripes.
		final int gapToRainbowRatio = 3 / 1;

		// Calculate the width and height for the stripes of the rainbow.
		double widthPerArc = totalWidth / (COLORS_OF_THE_RAINBOW.length * gapToRainbowRatio);
		double heightPerArc = totalHeight / (COLORS_OF_THE_RAINBOW.length * gapToRainbowRatio);

		/*
		 * Generate the rainbow stripes, from outer to inner arc. We need one iteration
		 * for every color and also one extra iteration for the sky-colored arc at the
		 * bottom ( hence i <= instead of i <).
		 */
		for (int i = 0; i <= COLORS_OF_THE_RAINBOW.length; i++) {
			// Get the current color from the array.
			// The last arc should have the same color as the sky
			Color currentColor;
			if (i == COLORS_OF_THE_RAINBOW.length) {
				currentColor = SKY_COLOR;
			} else {
				currentColor = COLORS_OF_THE_RAINBOW[i];
			}

			// Calculate the x and y position of the Arc that's to be drawn.
			// Because the stripes get smaller on the inside, we need to position them
			// accordingly.
			double currentX = (x + i * widthPerArc) / 2;
			double currentY = (y + i * heightPerArc) / 2;
			// Calc the width and height of the current Arc.
			// The size of the arc decreases every iteration.
			double currentWidth = totalWidth - i * widthPerArc;
			double currentHeight = totalHeight - i * heightPerArc;

			// Generate the arc and fill it with its respective color.
			GArc currentArc = new GArc(currentX, currentY, currentWidth, currentHeight, start, sweep);
			currentArc.setFilled(true);
			currentArc.setColor(currentColor);

			// Add the arc to the canvas.
			add(currentArc);

			// The pasture is painted last, so that it's placed in front of the rainbow.
			// double pastureStartY = skyHeight / 2;
			// addPasture(pastureStartY, skyWidth, skyHeight - pastureStartY);

		}

	}

	/**
	 * Adds a blue, filled rectangle at (0,0). The sky color is taken from the
	 * constant "Rainbow.skyColor".
	 * 
	 * @param width  The width of the sky
	 * @param height The *drum roll* height of the sky
	 */
	public void addSky(double width, double height) {
		// Mr. Blue Sky please tell us why
		GRect mrBlueSky = new GRect(width, height);
		// You had to hide away for so long (SoOoO LONG)
		mrBlueSky.setFilled(true);
		// Where did we go wrong?
		mrBlueSky.setColor(SKY_COLOR);
		// Hey there Mr. Blue (sky)
		add(mrBlueSky);
	}

	/**
	 * Adds a rich field of grass to the canvas (it's actually just a green
	 * rectangle). It will always start at x=0 to match the sky.
	 * 
	 * @param y      The Y coordinates the pasture is gonna start at.
	 * @param width  The width of the pasture.
	 * @param height The height of the pasture.
	 */
	public void addPasture(double y, double width, double height) {
		// I'm not gonna quote the lyrics of a song about grass here,
		// even though there are probably lots.

		// Create our charming meadow.
		GRect lushPasture = new GRect(0, y, width, height);

		// Define the color
		lushPasture.setFilled(true);
		lushPasture.setColor(Color.GREEN);

		// Add our delightful little rectangle to the canvas.
		add(lushPasture);
	}

	public static void main(String[] args) {
		new Rainbow(50, 50, 750, 550, 0, 360).start();
	}

}
