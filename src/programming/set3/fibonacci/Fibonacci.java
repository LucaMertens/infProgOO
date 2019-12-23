package programming.set3.fibonacci;

import acm.program.ConsoleProgram;

/**
 * Asks the user for a number n, then outputs the nth number of the fibonacci
 * sequence.
 */
public class Fibonacci extends ConsoleProgram {
	@Override
	public void run() {
		// Ask the user of a number.
		int n = readInt("Enter a number: ");

		// Don't continue execution if n is smaller than one
		if (n < 1) {
			println("Error");
			return;
		}

		// Define a "state". We will only be using the last two calculated
		// fibonacci-numbers at once.
		int prevNumber = 0;
		int currentNumber = 1;

		// Calculate the n-th fibonacci-number by repeatedly adding the current and the
		// previous number.
		for (int i = 1; i < n; i++) {
			// Calculate the next fibonacci number, but don't assign it to currentNumber
			// yet, because we will still need its value (instead, temporarily store it).
			int nextNumber = prevNumber + currentNumber;

			// Update the "state" to the next fibonacci number.
			prevNumber = currentNumber;
			currentNumber = nextNumber;
		}

		println(currentNumber);
	}

	public static void main(String[] args) {
		new Fibonacci().start();
	}

}
