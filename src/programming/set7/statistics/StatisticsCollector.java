package programming.set7.statistics;

import java.util.ArrayList;

/**
 * Manages a list of numbers and offers some statistical methods for that list.
 */
public class StatisticsCollector {
    /** The items managed by the StatisticsCollector. */
    private ArrayList<Double> items = new ArrayList<>();

    /** The smallest value in the list. */
    private double minimum = Double.POSITIVE_INFINITY;
    /** The largest value in the list. */
    private double maximum = Double.NEGATIVE_INFINITY;
    /** The sum off all items in the list. */
    private double sum = 0;

    /**
     * Adds an item to the list.
     * 
     * @param item The item to add.
     */
    public void addItem(double item) {
        items.add(item);

        // Update the rest of the state to match the new list.
        if (item < minimum) {
            minimum = item;
        }

        if (item > maximum) {
            maximum = item;
        }

        sum += item;
    }

    /**
     * How many items the list currently holds.
     * 
     * @return The amount of items in the list.
     */
    public int getCount() {
        return items.size();
    }

    /**
     * The sum of all items in the list.
     * 
     * @return the sum of all items in the list. {@code 0}, if the list is empty.
     */
    public double getSum() {
        return this.sum;
    }

    /**
     * The smallest value in the list.
     * 
     * @return the smallest value in the list, or {@code Double.POSITIVE_INFINITY},
     *         if the list is empty.
     */
    public double getMinimum() {
        return this.minimum;
    }

    /**
     * The largest value in the list.
     * 
     * @return the largest value in the list, or {@code Double.NEGATIVE_INFINITY},
     *         if the list is empty.
     */
    public double getMaximum() {
        return this.maximum;
    }

    /**
     * The average of all items in the list.
     * 
     * @return the average of all items in the list, or {@code 0}, if the list is
     *         empty.
     */
    public double getAverage() {
        if (getCount() == 0) {
            return 0;
        }

        return getSum() / getCount();
    }

    /**
     * The standart deviation of all items in the list.
     * 
     * @return the standart deviation.
     */
    public double getStandardDeviation() {
        if (getCount() == 0) {
            return 0;
        }

        // Calculate the sum of the squared differences between each item and the
        // average of all items
        double differenceSum = 0;
        for (Double item : items) {
            differenceSum += Math.pow(item - getAverage(), 2);
        }

        double variance = differenceSum / getCount();

        return Math.sqrt(variance);
    }

    public static void main(String[] args) {
        StatisticsCollector s = new StatisticsCollector();
        int[] numbers = { 5, 92, 42, 17, 53, 23, 13, 1, 6 };
        for (int number : numbers) {
            s.addItem(number);
        }

        System.out.println(s.getStandardDeviation());
    }
}