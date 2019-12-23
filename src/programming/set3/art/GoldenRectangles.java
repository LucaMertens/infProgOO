package programming.set3.art;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Ask the user for the width of the first rectangle and for the number n of
 * rectangles. Then draws n rectangles with the golden ratio (the next golden
 * rect will always be within the previous one).
 */
public class GoldenRectangles extends GraphicsProgram {
    /** The closest value for the golden ratio. */
    private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;

    @Override
    public void run() {
        // Ask for a width and a number of golden rectangles to draw.
        double width = readDouble("Enter the width of the first rectangle: ");
        int n = readInt("How many rectangles should be drawn? ");

        // Calculate the height so that the first rectangle has the golden ratio.
        double height = width / GOLDEN_RATIO;

        // Define where the outer rect should start. Will be overwritten for every rect.
        double x = 0;
        double y = 0;

        for (int i = 0; i < n; i++) {
            // Draw the rect with the params calculated in the previous iteration
            // (or with the start parameters).
            add(new GRect(x, y, width, height));

            // Now, calculate the parameters for the next rect:

            // If the width of the last rect is bigger than it's height, we need to draw a
            // rectangle with a bigger height than width next and vice versa.
            if (width > height) {

                // Because of a/b = (a+b)/a, where a is the longer side (here, a = width),
                // we can construct the next rect with b = a-b.
                // Because GRect only asks for the width and height (not which side is longer),
                // the formula is: newWidth = oldWidth - height.
                width -= height;

                // We want to align every 4th rect to the right within its outer rect.
                if (i % 4 == 0) {
                    x += height;
                }
            }
            // See explanation at (width > height).
            else if (height > width) {

                // See explanation at width -= height.
                height -= width;
                // The 5th, 9th, 13th etc. rect need to be vertically aligned at the bottom of
                // their outer rects.
                if ((i - 1) % 4 == 0) {
                    y += width;
                }
            }

        }
    }

    public static void main(String[] args) {
        new GoldenRectangles().start();
    }
}