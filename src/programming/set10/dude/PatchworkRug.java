package programming.set10.dude;

import java.util.Base64;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.awt.Color;

import acm.program.GraphicsProgram;
import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

/**
 * Upon execution, asks for a number of rows and a number of columns, then draws
 * a rug consisting of 3 different Patches.
 */
public class PatchworkRug extends GraphicsProgram {

    @Override
    public void run() {
        int numberOfRows = readInt("Enter the number of rows: ");
        int numberOfColumns = readInt("Enter the number of columns: ");

        drawPatchwork(numberOfRows, numberOfColumns);
    }

    /**
     * Returns a patch for a row- and column-index, so that on a rug larger than
     * 2*2, every Patch is used at least once.
     * 
     * @param row The row of the Patch, where 0 is the topmost row.
     * @param col The column of the Patch, where 0 is the leftmost column.
     * @return a fitting Patch for the provided position.
     */
    Patch getPatch(int row, int col) {
        int val = (row + col) % 3;
        switch (val) {
        case 0:
            return new EduroamLogo();

        case 1:
            return new MrKrabsPatch();

        default:
            return new Triforce();

        }
    }

    /**
     * Draws a grid of Patches.
     * 
     * @param numberOfRows    How many rows the grid should have.
     * @param numberOfColumns How many columns the grid should have.
     */
    public void drawPatchwork(int numberOfRows, int numberOfColumns) {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                add(getPatch(row, col), col * 100, row * 100);
            }
        }
    }

    public static void main(String[] args) {
        new PatchworkRug().start();
    }

}

/**
 * Represents a patch in a patchwork. Will be used as a superclass for every
 * Patch.
 */
class Patch extends GCompound {
    /** The width every Patch will have. */
    public static final int WIDTH = 100;
    /** The height every Patch will have. */
    public static final int HEIGHT = 100;

    /**
     * Standart-Constructor for every Patch. Subclasses of Patch will implicitly
     * call this method unless they implement an own constructor.
     */
    Patch() {
        this.drawBackground();
        this.drawContent();
    }

    /**
     * Draws a default background. Subclasses of Patch can either overwrite this
     * method with an own background or use this method.
     */
    public void drawBackground() {
        GRect background = new GRect(WIDTH, HEIGHT);
        background.setFilled(true);
        background.setColor(new Color(0, 76, 64));
        add(background);
    }

    /**
     * Converts a B64-String into an Image-Representation.
     * 
     * @param base64String Base64-encoded image data.
     * @return A BufferedImage from the decoded B64-String.
     */
    public static BufferedImage base64ToGImage(String base64String) {
        byte[] data = Base64.getDecoder().decode(base64String);

        BufferedImage outputImage;
        try {
            outputImage = ImageIO.read(new ByteArrayInputStream(data));
        } catch (Exception e) {
            outputImage = null;
        }

        return outputImage;
    }

    /**
     * Draws the content of a tile. This method can be overwritten by subclasses of
     * Patch, in order to draw their own content.
     */
    public void drawContent() {
        // Empty by default. Can be overwritten by subclasses.
    }
}

/**
 * Draws a certain dinosaur that everyone who's been to the Audimax before will
 * be familiar with.
 */
class EduroamLogo extends Patch {

    /** The chrome-dinosaur as a Base-64-String. */
    private static final String DINO_STRING = "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";
    /** The chrome-dinosaur as an Image. */
    private static final BufferedImage DINO_IMAGE = base64ToGImage(DINO_STRING);

    @Override
    public void drawContent() {
        // Draw a green circle behind the dinosaur.
        GOval circle = new GOval(80, 80);
        circle.setLocation((WIDTH - circle.getWidth()) / 2, 0);
        circle.setFilled(true);
        circle.setColor(new Color(0, 121, 107));
        add(circle);

        // Draw the dinosaur.
        GImage dino = new GImage(DINO_IMAGE);
        dino.setSize(WIDTH - 40, HEIGHT - 40);
        // Place the dino in the middle of the circle
        // (shifted 2 px to the right for asthetical reasons).
        dino.setLocation((WIDTH - dino.getWidth()) / 2, (circle.getHeight() - dino.getHeight()) / 2 + 2);
        add(dino);

        // Draw the label.
        GLabel label = new GLabel("Eduroam");
        label.setColor(Color.WHITE);
        label.setLocation((WIDTH - label.getWidth()) / 2, HEIGHT - label.getDescent() - 2);
        add(label);

    }

}

/** Mr. Krabs as a Patch, but his body is actually a Mandelbrot. */
class MrKrabsPatch extends Patch {
    /**
     * A rotated Mandelbrot-Fractal, which will be (mis-)used as the body of Mr.
     * Krabs.
     */
    private static final int[][] ROTATED_MANDELBROT = letsGetThisBread(WIDTH - 30, HEIGHT - 10);

    @Override
    public void drawContent() {
        GImage mandelImage = new GImage(ROTATED_MANDELBROT);
        add(mandelImage, (WIDTH - mandelImage.getWidth()) / 2, 5);

        // Draw 2 eyes and 2 eyeballs.
        for (int i = 0; i < 2; i++) {
            GOval eye = new GOval(5, 30);

            eye.setLocation(40 + i * 12, 5);
            eye.setColor(Color.WHITE);
            eye.setFilled(true);
            add(eye);

            GOval eyeball = new GOval(3, 3);
            eyeball.setLocation(eye.getX() + eye.getWidth() / 2, eye.getHeight() / 2);
            eyeball.setFilled(true);
            add(eyeball);
        }
    }

    /**
     * Generates a Mandelbrot rotated by 90 degrees.
     * 
     * @param width  The width of the (flipped) fractal.
     * @param height The width of the (flipped) fractal.
     * @return The mandelbrot as an array of rows, where each row is an array of
     *         columns. This can be used for creating a GImage, for example.s
     */
    private static int[][] letsGetThisBread(int width, int height) {
        int[][] result = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // x,y and width, height are intentionally switched here to rotate the brot.
                Color squareColor = isInMandelbrotSet(y, x, height, width) ? Color.RED : new Color(0, 0, 0, 0);
                result[y][x] = squareColor.getRGB();
            }
        }

        return result;
    }

    /**
     * Returns whether a given square is part of the Mandelbrot-Set.
     * 
     * @param x      The x-index of the pixel, where {@code 0} is the leftmost
     *               pixel.
     * @param y      The y-index of the pixel, where {@code 0} is the top pixel.
     * @param width  How wide the Mandelbrot is.
     * @param height How high the Mandelbrot is.
     * @return whether the pixel is part of the Mandelbrot-Set.
     */
    private static boolean isInMandelbrotSet(int x, int y, double width, double height) {
        // The complex number that is represented by the current square (in the complex
        // plane).
        double cReal = (3.0 * (x + 1)) / width - 2;
        double cIm = (2.0 * (y + 1)) / height - 1;
        // Intialize the sequence z with zReal and zImaginary = 0.
        double zReal = 0;
        double zIm = 0;
        for (int i = 0; i < 50; i++) {
            // Save these expressions because they're used twice per loop.
            double zRealSquared = Math.pow(zReal, 2);
            double zImaginarySquared = Math.pow(zIm, 2);
            // If this case is met, we know that the sequence approaches infinity, meaning
            // that it's not in the Mandelbrot-Set.
            if ((zRealSquared + zImaginarySquared) > 4) {
                return false;
            }
            // Calculate the next element in the sequence.
            zReal = zRealSquared - zImaginarySquared + cReal;
            zIm = 2 * zReal * zIm + cIm;
        }
        return true;
    }
}

/** The famous Triforce from Call of Duty. */
class Triforce extends Patch {
    @Override
    public void drawContent() {
        // Draw the top triangle.
        GPolygon triangle1 = getEquilateralTriangle(50);
        add(triangle1, 75, 50);

        // Draw the bottom two triangles.
        add(getEquilateralTriangle(50), 50, 50 + triangle1.getHeight());
        add(getEquilateralTriangle(50), 100, 50 + triangle1.getHeight());
        return;
    }

    /**
     * Constructs a triangle with equal sidelengths and angles.
     * 
     * @param sideLength How long every edge of the triangle should be.
     * @return The triangle as a GPolygon.
     */
    private static GPolygon getEquilateralTriangle(double sideLength) {
        GPolygon tri = new GPolygon();
        tri.addVertex(-sideLength, 0);
        tri.addPolarEdge(sideLength, 60);
        tri.addPolarEdge(sideLength, -60);

        tri.setColor(new Color(255, 242, 0));
        tri.setFilled(true);

        return tri;
    }
}
