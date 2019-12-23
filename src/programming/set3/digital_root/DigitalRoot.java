package programming.set3.digital_root;

import acm.program.ConsoleProgram;

/**
 * Asks for a number n, then calculates the digital root of n.
 */
public class DigitalRoot extends ConsoleProgram {
	@Override
	public void run() {
		// Ask the user for a number.
		int n = readInt("Enter a number: ");

		// Don't continue if n is smaller than 1.
		if (n < 0) {
			println("Error");
			return;
		}

		// Repeat the following code until n only has one digit.
		while (n % 10 != n) {
			// Make n the sum of it's digits.
			n = digitSum(n);
		}

		// Print the digital root.
		println(n);
	}

	/**
	 * Returns the sum of all digits of a number n.
	 * 
	 * @param n The number to sum up.
	 * @return The digital sum.
	 */
	public int digitSum(int n) {
		int sum = 0;

		// Sum up every digit of n, until none is left.
		while (n > 0) {
			// The rest of n/10 will always be the last digit of n.
			sum += n % 10;
			// Use integer division to "remove" the last digit from n.
			n = n / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		new DigitalRoot().start();
	}

}
