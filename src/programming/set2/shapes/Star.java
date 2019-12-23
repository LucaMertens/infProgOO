package programming.set2.shapes;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * Asks for an amount of corners and two radiuses, then paints a star...
 * 
 * MAAAANN wating in the sky.
 */
public class Star extends GraphicsProgram {
    @Override
    public void run() {
        // Ask for the amount of corners and the radii.
        // That's apparently a valid plural form of radius. Magical, I know.
        int n = readInt("Enter the number of corners: ", 2, Integer.MAX_VALUE);
        int outerRadius = readInt("Enter the outer radius: ", 0, Integer.MAX_VALUE);
        int innerRadius = readInt("Enter the inner radius: ", 0, outerRadius);

        // Coordinates for positioning the star.
        // Set to the radius to ensure that the Star is fully visible.
        final int centerX = outerRadius;
        final int centerY = outerRadius;

        // The angle between two points of a regular polygon with n sides.
        // Will come in handy when calculating the points of the star.
        final double inscribedAngle = 2 * Math.PI / n;

        // Each iteration, one corner of the star (two lines per corner) will be drawn.
        for (int i = 0; i < n; i++) {
            // Calculate the first point of the triangle. It lies on the inner circle.
            double x1 = centerX + innerRadius * Math.cos(i * inscribedAngle);
            double y1 = centerY + innerRadius * Math.sin(i * inscribedAngle);

            // The second point of the triangle will be on the outer radius.
            // We add half of the inscribed angle here, because we want to produce a point
            // between the previous and the next point (angle-wise).
            double x2 = centerX + outerRadius * Math.cos(i * inscribedAngle + inscribedAngle / 2);
            double y2 = centerY + outerRadius * Math.sin(i * inscribedAngle + inscribedAngle / 2);

            // Paint the first Line.
            add(new GLine(x1, y1, x2, y2));

            // The third point will be on the inner circle again.
            double x3 = centerX + innerRadius * Math.cos((i + 1) * inscribedAngle);
            double y3 = centerY + innerRadius * Math.sin((i + 1) * inscribedAngle);

            // Paint the second line.
            add(new GLine(x2, y2, x3, y3));
        }
    }

    public static void main(String[] args) {
        new Star().start();
    }
}