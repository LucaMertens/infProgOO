package programming.set1.arithmetics;

import acm.program.ConsoleProgram;

/**
 * This class adds not 1, not 2, but 3 (in words: ＴＨＲＥＥ) integers.
 */
public class Add3Integers extends ConsoleProgram {

	public void run() {
		// Sequentially prompt the user to enter the three integers.
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = readInt("Enter n3: ");

		// Add the integers.
		int total = n1 + n2 + n3;
		// Print the sum of the three integers to the console.
		println("The total is " + total + ".");
	}

	public static void main(String[] args) {
		new Add3Integers().start();
	}

}
