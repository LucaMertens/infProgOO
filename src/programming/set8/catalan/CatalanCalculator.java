package programming.set8.catalan;

/**
 * A class for recursively calculating catalan numbers.
 */
public class CatalanCalculator {

    /**
     * The number of calculated Catalan numbers. This is equal to the total number
     * of calls to the calculation method.
     */
    private int calculatedCatalanNumbersCount;

    /**
     * The number of times each Catalan number was calculated.
     */
    private int[] calculatedCatalanNumberCount = new int[0];

    /**
     * The longest path from the first method call to the deepest method call. This
     * is equal to the highest number of stack frames your calculation method has on
     * the stack during the calculations.
     */
    private int maximumStackDepth;

    /**
     * Calculate Catalan number C(n) and collect statistics along the way.
     * 
     * @param n which Catalan number to calculate.
     * @return the calculated Catalan number.
     * @throws IllegalArgumentException if n < 0.
     */
    public int catalan(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0, but was: " + n);
        }

        calculatedCatalanNumbersCount = 0;
        calculatedCatalanNumberCount = new int[n + 1];
        maximumStackDepth = n + 1;

        return catalanRecursive(n);
    }

    /**
     * Recursively calculates a catalan number, updating stats with every call.
     * 
     * @param n which Catalan number to calculate.
     * @return the calculated Catalan number.
     */
    private int catalanRecursive(int n) {
        calculatedCatalanNumbersCount++;
        calculatedCatalanNumberCount[n]++;

        if (n == 0) {
            return 1;
        }

        int sum = 0;
        for (int k = 0; k < n; k++) {
            sum += (catalanRecursive(k) * catalanRecursive(n - 1 - k));
        }
        return sum;
    }

    /**
     * Returns the total number of Catalan numbers computed to compute the one
     * requested by the user.
     * 
     * @return number of calculated Catalan numbers.
     * @throws IllegalStateException if this method is called before
     *                               {@link #catalan(int)} was called.
     */
    public int getCalculatedCatalanNumbersCount() {
        if (calculatedCatalanNumbersCount == 0) {
            throw new IllegalStateException("No catalan number has been calculated yet.");
        }
        return calculatedCatalanNumbersCount;
    }

    /**
     * Returns the number of times the given Catalan number was computed to compute
     * the one requested by the user.
     * 
     * @param i the Catalan number whose computation statistics to return.
     * @return how often C(i) was computed.
     * @throws IllegalStateException    if this method is called before
     *                                  {@link #catalan(int)} was called.
     * @throws IllegalArgumentException if the index i is invalid.
     */
    public int getCalculatedCatalanNumberCount(int i) {
        if (calculatedCatalanNumbersCount == 0) {
            throw new IllegalStateException("No catalan number has been calculated yet.");
        }
        if (i >= calculatedCatalanNumberCount.length) {
            throw new IllegalArgumentException();
        }

        return calculatedCatalanNumberCount[i];
    }

    /**
     * Returns the maximum stack depth encountered while computing the requested
     * Catalan number.
     * 
     * @return maximum stack depth.
     * @throws IllegalStateException if this method is called before
     *                               {@link #catalan(int)} was called.
     */
    public int getMaximumStackDepth() {
        if (calculatedCatalanNumbersCount == 0) {
            throw new IllegalStateException("No catalan number has been calculated yet.");
        }

        return maximumStackDepth;
    }

}