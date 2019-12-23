package programming.set6.optimus;

import acm.program.ConsoleProgram;

/**
 * Asks for a number n and calculates all prime numbers up to n (starts with 2).
 */
public class SieveOfEratosthenes extends ConsoleProgram {

    @Override
    public void run() {
        println("This program lists all prime numbers > 1 and <= n.");
        // Ask for an n until it's valid.
        int n;
        do {
            n = readInt("Enter n > 1: ");
        } while (n < 2);

        // Create an array of ints.
        // The length will be n-1, because the numbers in this array start at 2.
        int[] twoToN = new int[n - 1];

        // Fill the array.
        for (int i = 0; i < twoToN.length; i++) {
            // Because the numbers start at 2, the index is off by two.
            twoToN[i] = i + 2;
        }

        // Because the first value in twoToN (2) is a prime number,
        // the index of the first prime number is 0.
        int currentPrimeNumberIndex = 0;

        while (currentPrimeNumberIndex >= 0) {
            int primeNumber = twoToN[currentPrimeNumberIndex];
            println(primeNumber);

            // Set multiples of the prime number to 0, because they're definitly not prime.
            for (int i = currentPrimeNumberIndex; i < twoToN.length; i += primeNumber) {
                twoToN[i] = 0;
            }

            // The next prime number will be the next remaining number != 0 in the array.
            currentPrimeNumberIndex = nextNonZero(twoToN, currentPrimeNumberIndex + 1);
        }

    }

    /**
     * Find the next non-zero value, starting from a specific index.
     * 
     * @param array     The array to search in.
     * @param startFrom The index from which to start the search. If the element at
     *                  this index is non-zero itself, it will be returned.
     * @return The index of the next non-zero number, or -1 if none was found.
     */
    public int nextNonZero(int[] array, int startFrom) {
        // Check whether the index is valid.
        if (startFrom >= array.length) {
            return -1;
        }

        // Search the array from the specified index.
        for (int i = startFrom; i < array.length; i++) {
            // If a non-zero value is found, return it.
            if (array[i] != 0) {
                return i;
            }
        }

        // If no non-zero value was found in the array, return an invalid index.
        return -1;
    }

    public static void main(String[] args) {
        new SieveOfEratosthenes().start();
    }
}