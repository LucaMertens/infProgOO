package programming.set5.pi;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import java.awt.Color;

/**
 * Approximates the value of PI and visualizes the process by drawing aa
 * approximate circle.
 */
public class PiApproximator extends GraphicsProgram {
    /** The side length of the bounding rect. */
    private static final int SIDE_LENGTH = 400;
    /** How many points the program should draw (in- and outside the circle). */
    private static final int TOTAL_POINTS = 10000;

    /** The random generator to be used in this object. */
    private RandomGenerator rgen = RandomGenerator.getInstance();

    @Override
    public void run() {
        // Draw the bounding rectangle.
        add(new GRect(SIDE_LENGTH, SIDE_LENGTH));

        // A counter for how many points were in the circle so far.
        int pointsInCircle = 0;
        // Iterate TOTAL_POINTS-times
        for (int i = 0; i < TOTAL_POINTS; i++) {
            // Create a random point. Its coordinates will be between -1 and 1,
            // so don't draw it yet.
            GPoint currentPoint = randomPoint();

            // Points within the circle will be blue, others gray.
            Color color;
            if (isInCircle(currentPoint)) {
                pointsInCircle++;
                color = Color.BLUE;
            } else {
                color = Color.LIGHT_GRAY;
            }

            // Calculate the coordinates we need for visualising our circle.
            // Each oval will be one point in that visualisation.
            double ovalX = (currentPoint.getX() + 1) * SIDE_LENGTH / 2;
            double ovalY = (currentPoint.getY() + 1) * SIDE_LENGTH / 2;
            // Construct the circle and set its color.
            GOval oval = new GOval(ovalX, ovalY, 1, 1);
            oval.setColor(color);

            add(oval);
        }
        // Calculate an approximate value based on how many points out of the total
        // points were in the circle.
        double piApproximation = (double) pointsInCircle / TOTAL_POINTS * 4;
        println(piApproximation);
    }

    /**
     * Randomly generates a new point whose x and y coordinates lie between -1 and
     * 1.
     * 
     * @return random point.
     */
    public GPoint randomPoint() {
        // Generate two different random coordinates between -1 and 1.
        double pointX = rgen.nextDouble(-1, 1);
        double pointY = rgen.nextDouble(-1, 1);

        return new GPoint(pointX, pointY);
    }

    /**
     * Checks if the point with the given coordinates is inside the circle with
     * radius 1 centered at the coordinate system's origin.
     * 
     * @param unitPoint the point to check.
     * @return {@code true} if the point is inside the circle, {@code false} if it's
     *         not.
     */
    public boolean isInCircle(GPoint unitPoint) {
        // Calculate the length from the origin (0,0) to the point.
        double vectorLength = Math.hypot(unitPoint.getX(), unitPoint.getY());
        // Because the circle has a radius of 1 and its center is at (0,0),
        // only points that satisfy length(from 0,0) < 1 will be within the circle.
        return (vectorLength < 1);
    }

    public static void main(String[] args) {
        new PiApproximator().start();
    }

}