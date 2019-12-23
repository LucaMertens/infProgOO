package programming.set8.links;

/**
 * An element of a linked list. Stores a value and a reference to the next
 * element in the list.
 * 
 * @param <T> The type of this LinkedElement's value.
 */
public class LinkedElement<T> {
    /** The value stored by this element. */
    private T value;
    /** A link to the next element in the linked list. */
    private LinkedElement<T> nextElement;

    /**
     * Constructs a lone LinkedElement.
     * 
     * @param value The value of the Element.
     */
    public LinkedElement(T value) {
        this.value = value;
    }

    /**
     * Returns the value of the i-th linked element, assuming the current element to
     * be at index 0.
     * 
     * @param i 0-based index of the element whose value to return.
     * @return the i-th element's value, or {@code null} if there is no element with
     *         that index.
     */
    public T get(int i) {
        if (i == 0) {
            return value;
        }
        if (nextElement == null) {
            return null;
        }

        // Recursively traverse the linked list, until the i-th element is found.
        return nextElement.get(i - 1);
    }

    /**
     * Returns the i-th linked element, assuming the current element to be at index
     * 0.
     * 
     * @param i 0-based index of the element to return.
     * @return the i-th element.s
     */
    private LinkedElement<T> getElement(int i) {
        if (i == 0) {
            return this;
        }
        if (nextElement == null) {
            throw new IndexOutOfBoundsException();
        }
        return nextElement.getElement(i - 1);
    }

    /**
     * Adds a new linked element holding the given value at the end of the linked
     * elements.
     * 
     * @param newVal the new value.
     */
    public void add(T newVal) {
        if (nextElement != null) {
            nextElement.add(newVal);
        } else {
            nextElement = new LinkedElement<T>(newVal);
        }
    }

    /**
     * Removes the i-th element from the linked elements. If {@code i == 0}, this
     * will effectively remove the head element. Thus, this method returns the
     * linked element that is the new head element.
     * 
     * @param i index of the element to remove.
     * @return the new head element.
     */
    public LinkedElement<T> remove(int i) {
        // If the head should be removed, simply return the next element.
        // The previous head will be garbage collected.
        if (i == 0) {
            return nextElement;
        }

        // Get the element that comes before the element to remove.
        LinkedElement<T> prevElement = getElement(i - 1);

        // Set the link of the previous element to the link of the next element,
        // effectivly removing the item in the middle.
        prevElement.nextElement = prevElement.nextElement.nextElement;

        // Return the head.
        return this;
    }

    /*
     * public void printAll() { System.out.println(value); if (nextElement != null)
     * { nextElement.printAll(); } }
     */

}