package programming.set4.pyramid;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;

/**
 * Asks for the number of tiles in the bottom layer, then draws a Pyramid based
 * on that. The bottom layer of the Pyramid will be plain red, the top layer
 * will be bright red and the tiles in between will interpolate from plain red
 * to bright red.
 */
public class MethodicalPyramid extends GraphicsProgram {
	/** The color of the bottom row. */
	public static final Color BOTTOM_COLOR = new Color(255, 0, 0);
	/** The color of the top row. */
	public static final Color TOP_COLOR = new Color(255, 220, 220);

	/** The width of every tile of the pyramid. */
	public static final double TILE_WIDTH = 50;
	/** The height of every tile of the pyramid. */
	public static final double TILE_HEIGHT = 15;

	public void run() {
		// Ask for the amount of tiles in the bottom layer.
		int n = readInt("How many tiles should the bottom layer have? ", 0, Integer.MAX_VALUE);

		// Draw n layers, because a pyramid with n bottom tiles will have n layers.
		for (int i = 0; i < n; i++) {
			drawLayer(i, n, layerColor(i, n));
		}

	}

	/**
	 * Returns the color to be used for bricks in the given layer.
	 * 
	 * @param layerIndex     index of the layer whose color to return. {@code 0} is
	 *                       the bottom layer, {@code numberOfLayers - 1} is the top
	 *                       layer.
	 * @param numberOfLayers the number of layers in the pyramid.
	 * @return the color to be used for the given layer, or {@code null} if
	 *         {@code layerIndex} is invalid.
	 */
	public Color layerColor(int layerIndex, int numberOfLayers) {
		// Because layerIndex = (numberOfLayers - 1) is the top layer,
		// it can't be higher than that.
		if (layerIndex < 0 || layerIndex >= numberOfLayers) {
			return null;
		}

		// Needed for calculating the layerColor later.
		// Fraction = 1 will be for the top layer,
		// fraction = 0 will be for the bottom layer.
		double fraction = (double) layerIndex / (numberOfLayers - 1);

		// Every color in the pyramid will be a shade of red.
		int red = BOTTOM_COLOR.getRed();
		// Calc a value between the green values of the bottom and top color.
		// Because new Color() expects an integer, we need to round this value.
		int green = (int) Math.round(interpolate(BOTTOM_COLOR.getGreen(), TOP_COLOR.getGreen(), fraction));
		// The blue and green color-values for the layer will be equal.
		int blue = green;

		return new Color(red, green, blue);
	}

	/**
	 * Returns a linear interpolation between two values.
	 * 
	 * @param first    The start value for the interpolation.
	 * @param last     The end value for the interpolation.
	 * @param fraction A value between 0 and 1. For {@code fraction = 0},
	 *                 {@code first} is returned; For {@code fraction = 1},
	 *                 {@code last} is returned.
	 * @return An interpolated value between {@code first} and {@code last}.
	 */
	public double interpolate(double first, double last, double fraction) {
		// Calculate and return the interplation.
		return first * (1 - fraction) + last * fraction;
	}

	/**
	 * Draws the given layer with bricks filled with the given color. If
	 * {@code layerIndex} is invalid, no bricks at all should be drawn.
	 * 
	 * @param layerIndex     index of the layer to draw. {@code 0} is the bottom
	 *                       layer, {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers the number of layers in the pyramid.
	 * @param layerColor     color the layer's bricks should be filled with.
	 */
	public void drawLayer(int layerIndex, int numberOfLayers, Color layerColor) {
		// Calculate values for the whole layer.
		int numberOfTiles = numberOfLayers - (layerIndex);
		double layerX = layerIndex * (TILE_WIDTH / 2);
		double layerY = TILE_HEIGHT * (numberOfLayers - (layerIndex + 1));

		// Draw the layer, tile by tile.
		for (int i = 0; i < numberOfTiles; i++) {
			// Used for positioning the tiles next to each other.
			double tileX = layerX + i * TILE_WIDTH;

			GRect currentTile = new GRect(tileX, layerY, TILE_WIDTH, TILE_HEIGHT);

			// Set the tiles colors.
			currentTile.setColor(Color.black);
			currentTile.setFillColor(layerColor);
			currentTile.setFilled(true);

			// Add the tile to the canvas.
			add(currentTile);
		}
	}

	public static void main(String[] args) {
		new MethodicalPyramid().start();
	}

}
