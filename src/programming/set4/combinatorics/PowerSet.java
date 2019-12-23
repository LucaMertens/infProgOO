package programming.set4.combinatorics;

import java.util.Stack;

import acm.program.ConsoleProgram;

/**
 * Asks for an int N (0 ≤ N ≤ 10) and computes the powerset of M = {0 , … , N}.
 */
public class PowerSet extends ConsoleProgram {
    @Override
    public void run() {
        // Ask for n until it's valid.
        int n;
        while (true) {
            n = readInt("Enter N (0 <= N <= 10): ");
            if (n > 10) {
                println("N must be <= 10.");
            } else if (n < 0) {
                println("N must be >= 0.");
            } else {
                break;
            }
        }

        // A powerset of a set S has the cardinality 2^n, with n beeing the cardinality
        // of S.
        int powerSetLength = 2 << n;

        // To get every integer from 0 to one, we can simply "borrow" the greatest
        // subset.
        Stack<Integer> mSet = intToSubset(powerSetLength - 1);
        println("The powerset of " + mSet + " is:");

        // Calculate every subset of M.
        for (int i = 0; i < powerSetLength; i++) {
            // Enumerating every int from 0 to powerSetLength yields every possible
            // combination of n binary digits, which is very close to what we are looking
            // for.
            println(intToSubset(i));
        }
    }

    /**
     * Returns a stack with all places of a binary number where its bits are 1.
     * 
     * @param n The integer to magically turn into a subset.
     * @return The set of integers described above. Eg. for n = 25 = 11001 (binary),
     *         returns [0,3,4] @
     */
    Stack<Integer> intToSubset(int n) {
        // We only need a push method, so a stack suffices.
        // I don't know if it's actually faster than an arrayList, probably not.
        Stack<Integer> subSet = new Stack<Integer>();

        // The binary number's place were currently looking at.
        int place = 0;

        // n is going to be right-shifted until it's 0.
        while (n > 0) {
            // If the last bit is a 1, add the place of that digit to the stack.
            if ((n & 1) == 1) {
                subSet.push(place);
            }
            // Continue to the next place of n.
            n >>>= 1;
            place++;
        }

        return subSet;
    }

    public static void main(String[] args) {
        new PowerSet().start();
    }
}