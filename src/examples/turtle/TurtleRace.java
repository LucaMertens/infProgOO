package examples.turtle;

import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

/**
 * TurtleTest
 */
public class TurtleRace extends GraphicsProgram {

    private GTurtle[] turtles;

    @Override
    public void run() {
        createTurtles(10);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
            for (GTurtle tort : turtles) {
                tort.forward();
            }
            // turt.move(2, 1);

        }
    }

    void createTurtles(int n) {
        turtles = new GTurtle[n];
        for (int i = 0; i < n; i++) {
            GTurtle tort = new GTurtle();
            tort.setLocation(0, 100 * (i));
            turtles[i] = tort;
            add(tort);
        }
    }

    public static void main(String[] args) {
        new TurtleRace().start();
    }
}