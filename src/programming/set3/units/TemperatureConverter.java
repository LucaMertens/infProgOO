package programming.set3.units;

import acm.program.ConsoleProgram;

/**
 * Asks the user whether to convert Celsius to Fahrenheit or Celsius to
 * Fahrenheit. Then repeatedly (until the temperature -1337 is entered) asks for
 * a temperature and prints the converted temperature.
 */
public class TemperatureConverter extends ConsoleProgram {
    @Override
    public void run() {
        // Display welcome message.
        String message = "What do you want me to do?\n" + "(1) Convert Celsius to Fahrenheit\n"
                + "(2) Convert Fahrenheit to Celsius";
        println(message);
        // Ask the user to enter a conversion mode.
        // Term: "readInt("Mode: ")" is a method call.
        int mode = readInt("Mode: ");

        // Check if a valid mode was entered. If not, stop the run function.
        if (mode != 1 && mode != 2) {
            return;
        }

        // This var will be reassigned every iteration of the while loop.
        double temperature;

        while (true) {
            // Ask for a temperature (every iteration).
            temperature = readDouble("Temperature: ");

            // Exit the while loop if the user enters -1337.
            if (temperature == -1337) {
                println("Goodbye!");
                break;
            }

            double converted;

            switch (mode) {
            case 1:
                // Formula for converting Celsius to Fahrenheit.
                // This expression needs to be cast to double to avoid integer division.
                converted = (double) 9 / 5 * temperature + 32;
                break;
            case 2:
                // Formula for converting a temperature in Fahrenheit to Celsius.
                // Terms: temperature is a variable, 32 is a constant,
                // (temperature - 32) is an expression in parantheses
                converted = (double) 5 / 9 * (temperature - 32);
                break;

            // Because we check if the mode is 1 or 2 earlier, the default case will never
            // be met.
            default:
                return;
            }

            // Print the result of this iteration.
            println(converted);
        }

    }

    public static void main(String[] args) {
        new TemperatureConverter().start();
    }
}
