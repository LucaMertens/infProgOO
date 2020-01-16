package programming.set10.dude;

import java.util.Base64;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * PatchworkRug
 */
public class PatchworkRug extends GraphicsProgram {
    @Override
    public void run() {
        int numberOfRows = 20; // readInt();
        int numberOfColumns = 20;

        drawPatchWork(numberOfRows, numberOfColumns);
    }

    public void drawPatchWork(int numberOfRows, int numberOfColumns) {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                add(new MandelbrotPatch(col * 100, row * 100));
            }
        }
    }

    public static void main(String[] args) {
        new PatchworkRug().start();
    }

}

class Patch extends GCompound {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    Patch(double x, double y) {
        this.drawBackground(x, y);
        this.drawContent(x, y);
    }

    public void drawBackground(double x, double y) {
        GRect background = new GRect(WIDTH, HEIGHT);
        background.setLocation(x, y);
        background.setFilled(true);
        background.setColor(new Color(0, 76, 64));
        add(background);
    }

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

    public void drawContent(double x, double y) {
        GRect greg = new GRect(100, 20);
        greg.setColor(Color.BLACK);
        add(greg);
        return;
    }
}

class EduroamLogo extends Patch {

    EduroamLogo(double x, double y) {
        super(x, y);
    }

    private static final String DINO_STRING = "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";
    private static final BufferedImage DINO_IMAGE = base64ToGImage(DINO_STRING);

    @Override
    public void drawContent(double x, double y) {
        GOval circle = new GOval(80, 80);
        circle.setLocation(x + (WIDTH - circle.getWidth()) / 2, y);
        circle.setFilled(true);
        circle.setColor(new Color(0, 121, 107));
        add(circle);

        GImage dino = new GImage(DINO_IMAGE);
        dino.setSize(WIDTH - 40, HEIGHT - 40);
        dino.setLocation(x + (WIDTH - dino.getWidth()) / 2, y + (circle.getHeight() - dino.getHeight()) / 2 + 2);
        add(dino);

        GLabel label = new GLabel("Eduroam");
        label.setColor(Color.WHITE);
        label.setLocation(x + (WIDTH - label.getWidth()) / 2, y + HEIGHT - label.getDescent() - 2);
        add(label);

    }

}

class MandelbrotPatch extends Patch {
    MandelbrotPatch(double x, double y) {
        super(x, y);
        GImage mandelImage = new GImage(theBreadOfBreads);
        add(mandelImage);
    }

    private static final int[][] theBreadOfBreads = getMandelbrot(WIDTH, HEIGHT);

    private static int[][] getMandelbrot(int width, int height) {
        int[][] result = new int[width][height];

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color squareColor = isInMandelbrotSet(w, h, width, height) ? Color.RED : Color.;
                result[w][h] = squareColor.getRGB();
            }
        }

        return result;
    }

    private static boolean isInMandelbrotSet(int x, int y, double width, double height) {
        // The complex number that is represented by the current square (in the complex
        // plane).
        double cReal = (3.0 * (x + 1)) / width - 2;
        double cIm = (2.0 * (y + 1)) / height - 1;

        // Intialize the sequence z with zReal and zImaginary = 0.
        double zReal = 0;
        double zIm = 0;

        for (int i = 0; i < 200; i++) {
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
