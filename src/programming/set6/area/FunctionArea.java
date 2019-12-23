package programming.set6.area;

import acm.program.ConsoleProgram;

/**
 * A class containing a method to estimate the area of a predefined function.
 */
public class FunctionArea extends ConsoleProgram {
    @Override
    public void run() {
        println(approxFunctionArea(-1, 0, 0.2));
        println(approxFunctionArea(-1, 0, 0.3));
        println(approxFunctionArea(1, 4, 1.0));
        println(approxFunctionArea(1, 4, 0.2));
    }

    /**
     * The function whose area to calculate.
     * 
     * @param x the x coordinate.
     * @return the value of f at the x coordinate.
     */
    public double f(double x) {
        // This is the function whose area we want to calculate. Hardcoding
        // it here is a bit unfortunate; we can improve the design once we
        // know more about classes and interfaces
        return Math.sin(x) + Math.cos(0.5 * x);
    }

    /**
     * Calculates the height of a rectangle at the given x coordinate and with the
     * given width. The height of the rectangle is the function value at its left
     * and right side that is nearer to the x axis. If the function value is
     * negative, the height is negative.
     * 
     * @param x     the rectangle's x coordinate (left boundary).
     * @param width the rectangle's width.
     * @return the rectangle's height, which may actually be negative.
     */
    public double minRectHeight(double x, double width) {
        if (width < 0) {
            return 0;
        }
        // The left and right x coords of the rect
        double rectLeft = f(x);
        double rectRight = f(x + width);

        // We want the height of the rect whose absolute height is smaller than the
        // absolute height of the other rect.
        return Math.abs(rectLeft) <= Math.abs(rectRight) ? rectLeft : rectRight;
    }

    /**
     * Calculates the height of a rectangle at the given x coordinate and with the
     * given width. The height of the rectangle is the functiosn value at its left
     * and right side that is further from the x axis. If the function value is
     * negative, the height is negative.
     * 
     * @param x     the rectangle's x coordinate (left boundary).
     * @param width the rectangle's width.
     * @return the rectangle's height, which may actually be negative.
     */
    public double maxRectHeight(double x, double width) {
        if (width < 0) {
            return 0;
        }

        // The left and right x coords of the rect
        double rectLeft = f(x);
        double rectRight = f(x + width);

        // We want the height of the rect whose absolute height is greater than the
        // absolute height of the other rect.
        return Math.abs(rectLeft) >= Math.abs(rectRight) ? rectLeft : rectRight;
    }

    /**
     * Approximates the area enclosed by the x axis, {@link #f(double)}, and two
     * vertical lines at {@code left} and {@code right}. The approximation divides
     * the x axis section into different parts of width {@code rectWidth} (the
     * rightmost part may have to be smaller to keep it from extending beyond the
     * right boundary). For each part, the function computes the min and max
     * rectangle and uses the min rectangle's area plus half the difference of the
     * two rectangle areas as the approximate area for that part.
     * 
     * @param left      left boundary.
     * @param right     right boundary.
     * @param rectWidth width of the rectangles used to approximate the area.
     * @return the approximate area. If the left boundary is right of the right
     *         boundary, the result is 0.
     */
    public double approxFunctionArea(double left, double right, double rectWidth) {
        if (left > right || rectWidth <= 0) {
            return 0;
        }

        // The distance from the left to right boundary.
        double distance = right - left;

        // How many rects with the given rectHeight fit into the distance.
        int numberOfRegularRects = (int) Math.floor(distance / rectWidth);

        double area = 0;

        // We will draw as many regular rects as we can, plus one irregular, to fill the
        // remaining space.
        for (int i = 0; i <= numberOfRegularRects; i++) {
            // The x-coord of the current rect.
            double rectX = left + i * rectWidth;

            // The last rect might need to have a smaller width than the others.
            if (i == numberOfRegularRects) {
                rectWidth = distance - numberOfRegularRects * rectWidth;
            }

            // Calculate the area estimation under the graph for the current rectWidth.
            double maxRectArea = maxRectHeight(rectX, rectWidth) * rectWidth;
            double minRectArea = minRectHeight(rectX, rectWidth) * rectWidth;

            area += (maxRectArea + minRectArea) / 2;
        }

        return area;
    }

    public static void main(String[] args) {
        new FunctionArea().start();
    }
}