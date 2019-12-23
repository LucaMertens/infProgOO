package programming.set5.complex;

/**
 * Represents an immutable complex number and offers methods to calculate with
 * complex numbers.
 */
public class ComplexNumber {
    /** The real part of the complex number. */
    private final double re;
    /** The complex part of the complex number. */
    private final double im;

    /**
     * Constructs a ComplexNumber and initializes the real and imaginary parts with
     * 0.
     */
    ComplexNumber() {
        this(0, 0);
    }

    /**
     * Constructs a complex number and inititalizes the real and imaginary part with
     * the given values.
     * 
     * @param real      The real part of the complex number.
     * @param imaginary The imaginary part of the complex number.
     */
    ComplexNumber(double real, double imaginary) {
        this.re = real;
        this.im = imaginary;
    }

    /**
     * "Clones" a complex number.
     * 
     * @param cn The complex number to copy.
     */
    ComplexNumber(ComplexNumber cn) {
        this.re = cn.getReal();
        this.im = cn.getImaginary();
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }

    /**
     * The conjugate of this complex number as a new complex number. To quote
     * <a href="https://en.wikipedia.org/wiki/Complex_number">Wikipedia</a>: The
     * complex conjugate of the complex number z = x + yi is given by x − yi.
     * 
     * @return a new complex number which is the conjugate of the one the method was
     *         called on.
     */
    public ComplexNumber conjugate() {
        return new ComplexNumber(getReal(), -getImaginary());
    }

    /**
     * Adds two complex numbers and returns the result as a complex number.
     * 
     * @param other The complex number to add.
     * @return a new complex number which is the sum of the complex number the
     *         method was called on and {@code other}.
     */
    public ComplexNumber add(ComplexNumber other) {
        double newRe = this.getReal() + other.getReal();
        double newIm = this.getImaginary() + other.getImaginary();
        return new ComplexNumber(newRe, newIm);
    }

    /**
     * Subtracts two complex numbers and returns the result as a complex number.
     * 
     * @param other The complex number to subtract.
     * @return a new complex number which is the result of subtracting {@code other}
     *         from the complex number the method was called on.
     */
    public ComplexNumber subtract(ComplexNumber other) {
        double newRe = this.getReal() - other.getReal();
        double newIm = this.getImaginary() - other.getImaginary();
        return new ComplexNumber(newRe, newIm);
    }

    /**
     * Multiplies two complex numbers and returns the result as a complex number.
     * 
     * @param other The complex number to multiply with.
     * @return a new complex number which is the product of the complex number the
     *         method was called on and {@code other}.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        double newRe = (this.getReal() * other.getReal()) - (this.getImaginary() * other.getImaginary());
        double newIm = (this.getReal() * other.getImaginary()) + (this.getImaginary() * other.getReal());
        return new ComplexNumber(newRe, newIm);
    }

    /**
     * The reciprocal of a complex number ( 1 / complexNumber).
     * 
     * @return a new complex number which satisfies (1 / the complex number the
     *         method was called on).
     */
    public ComplexNumber reciprocal() {
        // The divisor will always be greater than 0.
        double divisor = Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2);

        return new ComplexNumber(getReal() / divisor, (getImaginary() / divisor)).conjugate();
    }

    /**
     * Divides this complex number by another and returns the result as a complex
     * number.
     * 
     * @param other The complex number to divide by.
     * @return null if the real and imaginary parts of {@code other} are 0.
     *         Otherwise, it returns a new complex number which is the result of
     *         dividing the current complex number by {@code other}.
     */
    public ComplexNumber divide(ComplexNumber other) {
        // Avoid dividing by a complex number equal to 0.
        if (other.getReal() == 0 && other.getImaginary() == 0) {
            return null;
        }
        // Multiplying this with 1/other is the same as dividing this/other.
        return this.multiply(other.reciprocal());
    }

    /**
     * The absolute value of this complex number. It can also be described as the
     * distance from (0,0) to (real, imaginary) in the complex plane.
     * 
     * @return the absolute value of the complex number (also called modulus).
     */
    public double abs() {
        return Math.sqrt(Math.pow(getReal(), 2) + Math.pow(getImaginary(), 2));
    }

    /**
     * Returns the real part of the complex number.
     * 
     * @return the real part of the complex number.
     */
    public double getReal() {
        return re;
    }

    /**
     * Returns the imaginary part of the complex number.
     * 
     * @return the imaginary part of the complex number.
     */
    public double getImaginary() {
        return im;
    }

}