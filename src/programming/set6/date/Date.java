package programming.set6.date;

/**
 * Represents a valid immutable date.
 *
 */
public class Date {
	/** An array of the amount of days in each month, starting at index 1. */
	public static final int[] NUMBER_OF_DAYS_IN_MONTHS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	/** An array of the month names, starting at index 1. */
	public static final String[] MONTH_NAMES = { null, "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	/** The year of the date. */
	private int year;
	/** The month of the date. */
	private int month;
	/** The day of the date. */
	private int day;

	/**
	 * Constructs a Date instance. Throws an exception if the given parameters are
	 * invalid.
	 * 
	 * @param year  The year of the date to construct.
	 * @param month The month of the date to construct.
	 * @param day   The day of the date to construct.
	 */
	public Date(int year, int month, int day) {
		// Check whether the arguments are valid, throw an exception if they aren't.
		if (!validate(year, month, day)) {
			throw new IllegalArgumentException("This is not a valid date.");
		}

		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * How many days there are in a given month in a given year.
	 * 
	 * @param year  The year, where 2000 represents the year 2000. Crazy stuff.
	 * @param month The month, where 1 represents January and 12 represents December
	 * @return the number of days in the given month of the given year, or {@code 0}
	 *         if the month or year is invalid.
	 */
	public static int getDaysInMonth(int year, int month) {
		if (year < 0 || month < 1 || month > 12) {
			return 0;
		}

		// "A year is a leap year if it is divisible by 4 and not divisible by 100
		// (unless it is also divisible by 400)."
		boolean isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

		// Special case for february, if the year is a leap year.
		if (month == 2 && isLeapYear) {
			return 29;
		}

		// Look up the number of days and return it.
		return NUMBER_OF_DAYS_IN_MONTHS[month];
	}

	/**
	 * Checks whether the given parameters represent a valid date.
	 * 
	 * @param year  The year of the date.
	 * @param month The month of the date.
	 * @param day   The day of the date.
	 * @return {@code true}, if the date is valid and {@code false} if it's not.
	 */
	public static boolean validate(int year, int month, int day) {
		int daysInMonth = getDaysInMonth(year, month);

		// daysInMonth already checks whether month and day are valid, so we can make
		// use of that here (at daysInMonth == 0)
		if (daysInMonth == 0 || day < 1 || day > daysInMonth) {
			return false;
		}

		return true;
	}

	/**
	 * Returns the number of the day represented by the Date instance (For example,
	 * January 20th 2019 is the 20th day of the year).
	 * 
	 * @return The day of the year.
	 */
	public int dayOfYear() {
		int dayOfYear = 0;
		// Sum up the days until the start of month of this Date.
		for (int i = 1; i < month; i++) {
			dayOfYear += getDaysInMonth(year, i);
		}
		// Add the days of this Date.
		dayOfYear += day;

		return dayOfYear;
	}

	/**
	 * Calculates how many days the other Date is off and returns that as an
	 * integer.
	 * 
	 * @param other The other Date.
	 * @return The difference. Positive, if {@code other} lies in the future,
	 *         otherwise, it's negative.
	 */
	public int sameYearDiff(Date other) {
		// The method is only properly defined if both Date instances represent dates in
		// the same year
		if (other.year != this.year) {
			return 0;
		}

		int difference = other.dayOfYear() - this.dayOfYear();
		return difference;
	}

	@Override
	public String toString() {
		// Return the date in a form like this: May 20, 2015
		return MONTH_NAMES[month] + " " + day + ", " + year;
	}

	/**
	 * Returns the year of the Date.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the Date.
	 * 
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns the month of the Date.
	 * 
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month of the Date.
	 * 
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Returns the day of the Date.
	 * 
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day of the Date.
	 * 
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	public static void main(String[] args) {
		System.out.println(new Date(2000,1,1));
	}
}
