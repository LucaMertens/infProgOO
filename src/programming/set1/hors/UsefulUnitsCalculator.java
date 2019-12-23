package programming.set1.hors;

import acm.program.ConsoleProgram;

/**
 * Asks for a decimal number and outputs that number interpreted as meters,
 * converted to horse lengths and vice versa. This class is not horsing around.
 */
public class UsefulUnitsCalculator extends ConsoleProgram {

	public void run() {
		/*
		 * The decimal number that will be converted later.
		 */
		double measurement = readDouble("Enter a measurement: ");

		// Print the measurement converted from meters to horse lengths.
		println(measurement / 2.4);
		// Print the measurement converted from horse lengths to meters.
		println(measurement * 2.4);
	}

	public static void main(String[] args) {
		new UsefulUnitsCalculator().start();
	}

}
