package examples.turtle;

import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;
import acm.util.Animator;

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
            for (GTurtle turtle : turtles) {
                turtle.setSpeed(Math.random());
            }
            // turt.move(2, 1);

        }
    }

    void createTurtles(int n) {
        turtles = new GTurtle[n];
        for (int i = 0; i < n; i++) {
            GTurtle tort = new GTurtle();
            tort.penDown();
            tort.setLocation(0, 68 * (i));
            turtles[i] = tort;
            add(tort);
        }
    }

    public static void main(String[] args) {
        new TurtleRace().start();
    }
}