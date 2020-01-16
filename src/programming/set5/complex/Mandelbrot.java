package programming.set5.complex;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;

/**
 * Draws a visualisation of the Mandelbrot-Set.
 */
public class Mandelbrot extends GraphicsProgram {
    /**
     * How many elements of each sequence should be checked at max, before it's
     * assumed that the sequence doesn't approach infinity. More iterations mean
     * more precise fractals, but are slower to compute.
     */
    public static final int MAX_ITERATIONS = 400;

    /** How wide and high each square should be. */
    private double squareLength;
    /** How wide the grid of squares should be (measured in squares). */
    private int widthInSquares;
    /** How high the grid of squares should be (measured in squares). */
    private int heightInSquares;

    @Override
    public void run() {
        // Ask user for input.
        squareLength = readDouble("Enter the length of each square: ");
        widthInSquares = readInt("Enter the width of the Mandelbrot (measured in Squares): ");
        heightInSquares = readInt("Enter the height of the Mandelbrot (measured in Squares): ");

        // Draw columns.
        for (int w = 0; w < widthInSquares; w++) {
            // Draw row.
            for (int h = 0; h < heightInSquares; h++) {
                Color squareColor = isInMandelbrotSet(w, h) ? Color.BLUE : Color.WHITE;
                drawSquare(w, h, squareColor);
            }
        }
    }

    /**
     * Returns whether a given square is part of the Mandelbrot-Set.
     * 
     * @param x The x-index of the square, where {@code 0} is the leftmost square
     *          and {@code widthInSquares - 1} is the rightmost one.
     * @param y The y-index of the square, where {@code 0} is the top square and
     *          {@code heightInSquares - 1} is the bottom one.
     * @return whether the square is part of the Mandelbrot-Set.
     */
    boolean isInMandelbrotSet(int x, int y) {
        // The complex number that is represented by the current square (in the complex
        // plane).
        double cReal = (3.0 * (x + 1)) / widthInSquares - 2;
        double cImaginary = (2.0 * (y + 1)) / heightInSquares - 1;
        ComplexNumber c = new ComplexNumber(cReal, cImaginary);

        // Intialize the sequence z with zReal and zImaginary = 0.
        ComplexNumber z = new ComplexNumber();

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            // Save these expressions because they're used twice per loop.
            double zRealSquared = Math.pow(z.getReal(), 2);
            double zImaginarySquared = Math.pow(z.getImaginary(), 2);

            // If this case is met, we know that the sequence approaches infinity, meaning
            // that it's not in the Mandelbrot-Set.
            if ((zRealSquared + zImaginarySquared) > 4) {
                return false;
            }

            // Calculate the next element in the sequence.
            double nextReal = zRealSquared - zImaginarySquared + c.getReal();
            double nextImaginary = 2 * z.getReal() * z.getImaginary() + c.getImaginary();
            z = new ComplexNumber(nextReal, nextImaginary);

        }

        // If we haven't found an element in the sequence that is greater than 2, we
        // assume that it won't approach infinity ==> part of Mandelbrot.
        return true;
    }

    /**
     * Draws one colored square in the grid at the specified x- and y-indexes.
     * 
     * @param x     The x-index of the square, where {@code 0} is the leftmost
     *              square and {@code widthInSquares - 1} is the rightmost one.
     * @param y     The y-index of the square, where {@code 0} is the top square and
     *              {@code heightInSquares - 1} is the bottom one.
     * @param color The color of the square.
     */
    void drawSquare(int x, int y, Color color) {
        GRect square = new GRect(x * squareLength, heightInSquares * squareLength - (y + 1) * squareLength,
                squareLength, squareLength);
        square.setColor(color);
        square.setFilled(true);
        add(square);

    }

    public static void main(String[] args) {
        new Mandelbrot().start();
    }
}