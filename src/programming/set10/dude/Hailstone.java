package programming.set10.dude;

/**
 * Hailstone
 */
public class Hailstone {

    public int hailstoneLength(int n) {
        if (n <= 0) {
            // This is the method exposed to the user. If the user enters a faulty argument,
            // unexpected things can happen, so we need to halt execution.
            throw new IllegalArgumentException("n needs to be greater than 0, but was: " + n);
        }

        return compute(n);
    }

    private int compute(int n) {
        // User-error should be caught by hailStoneLength. This method isn't exposed to
        // the user, so any error that occurs here is likely due to a faulty
        // implementation.
        assert n > 0 : "The argument n for the method compute was in an illegal range: " + n;

        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + even(n);
        } else {
            return 1 + odd(n);
        }
    }

    private int even(int n) {
        // Private method, so probably no user-error --> Assertion
        // It wouldn't make sense to call this method with an odd number.
        assert n > 1 && n % 2 == 0 : "The argument n for the method even was in an illegal range: " + n;

        return compute(n / 2);
    }

    private int odd(int n) {
        // Private method, so probably no user-error --> Assertion
        // It wouldn't make sense to call this method with an even number.
        assert n > 1 && n % 2 != 0 : "The argument n for the method odd was in an illegal range: " + n;

        return compute(3 * n + 1);
    }
}