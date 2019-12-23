package programming.set2.finance;

import acm.program.ConsoleProgram;

/**
 * Asks for a an amount of money and an interest rate. Prints out the value
 * (with compounded interest) after 1 and 2 years.
 */
public class InterestCalculator extends ConsoleProgram {
	@Override
	public void run() {
		// Ask the user for a starting balance and interest rate.
		double startingBalance = readDouble("Please enter a starting balance: ");
		double interestRate = readDouble("Please enter an annual interest rate: ");

		// Calculate and print the accumulated amount after 1 and 2 years.
		println("The balance after the first year is " + getBalanceAfter(startingBalance, interestRate, 1));
		println("The balance after the second year is " + getBalanceAfter(startingBalance, interestRate, 2));
	}

	/**
	 * Calculates the new value of a balance with compounded interest after a
	 * specified number of years.
	 * 
	 * @param startingBalance The initial balance.
	 * @param interestRate    The annual interest rate (in percent).
	 * @param years           The number of years.
	 * @return The balance after the specified amount of years.
	 */
	public double getBalanceAfter(double startingBalance, double interestRate, int years) {
		// Calculate the new balance with an exponential-growth-formula.
		double newBalance = startingBalance * Math.pow(1 + interestRate / 100, years);
		return newBalance;
	}

	public static void main(String[] args) {
		new InterestCalculator().start();
	}

}
