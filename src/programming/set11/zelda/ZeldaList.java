package programming.set11.zelda;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A list consisting of linked ZeldaElements.
 * 
 * @param <T> The type of every value in the list.
 */
public class ZeldaList<T> implements Iterable<T> {
    /** How many elements the list holds. */
    private int size = 0;
    /** The first element of the list. */
    private ZeldaElement<T> headElement = null;

    /**
     * Constructs a ZeldaList with its Head-Element set to the provided value.
     * 
     * @param value The value of the first element.
     */
    public ZeldaList(T value) {
        this.add(value);
    }

    /**
     * Constructs an empty ZeldaList.
     */
    public ZeldaList() {
        this.add(null);
    }

    /**
     * Adds the given value to the end of the list.
     * 
     * @param value the value to add. If {@code value == null}, nothing happens.
     */
    public void add(T value) {
        if (value == null) {
            return;
        }

        // Construct the Element to add.
        ZeldaElement<T> newElement = new ZeldaElement<T>();
        newElement.setValue(value);

        size++;

        // Special case: List is empty.
        if (headElement == null) {
            headElement = newElement;
            return;
        }

        // Iterate until the last element is found.
        ZeldaElement<T> currentElement = headElement;
        while (currentElement.getNextElement() != null) {
            currentElement = currentElement.getNextElement();
        }

        // Attach the new element to the last element.
        currentElement.setNextElement(newElement);

    }

    /**
     * Removes the first occurrence of the given value from the list.
     * 
     * @param value the value to remove. If this is {@code null}, nothing is removed.
     * @return {@code true} if the value was found and removed, {@code false} otherwise.
     */
    public boolean remove(T value) {
        if (value == null || headElement == null) {
            return false;
        }

        // Special case: if the first element needs to be deleted.
        if (headElement.getValue().equals(value)) {
            headElement = headElement.getNextElement();
            size--;
            return true;
        }

        ZeldaElement<T> prevElement;
        ZeldaElement<T> currentElement = headElement;

        while (currentElement.getNextElement() != null) {
            // Look at the next element of the list.
            prevElement = currentElement;
            currentElement = currentElement.getNextElement();

            if (currentElement.getValue() == value) {
                // Delete the element.
                // Will also work if currentElement.getNextElement() == null.
                prevElement.setNextElement(currentElement.getNextElement());
                size--;
                return true;
            }

        }

        // No match has been found in the whole list.
        return false;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        headElement = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the value at the given index in the list.
     * 
     * @param index the index of the element whose value to return.
     * @return the value at the given index, or {@code null} if the index is invalid.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        // Traverse the ZeldaList
        ZeldaElement<T> currentElement = headElement;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.getNextElement();
        }

        return currentElement.getValue();
    }

    /**
     * Returns the smallest index where the given value appears in the list, if it does.
     * 
     * @param value the value to look for.
     * @return the value's index or -1 if {@code value == null} or if the value is not in the list.
     */
    public int indexOf(T value) {
        if (value == null || headElement == null) {
            return -1;
        }

        ZeldaElement<T> currentElement = headElement;

        for (int i = 0; i < size; i++) {
            if (currentElement.getValue().equals(value)) {
                return i;
            }

            // Next iteration, look at the next element.
            currentElement = currentElement.getNextElement();
        }

        return -1;
    }

    /**
     * Checks if the given value appears anywhere in the list.
     * 
     * @param value the value to search for.
     * @return {@code true} if the value appears in the list, {@code false} if it doesn't or if it
     *         is {@code null}.
     */
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    /**
     * Checks if the list contains any elements.
     * 
     * @return {@code true} if the list is empty, {@code false} if it isn't.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ZeldaIterator();
    }

    /**
     * ZeldaIterator
     */
    public class ZeldaIterator implements Iterator<T> {
        private ZeldaElement<T> nextElement = headElement;

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }

        @Override
        public T next() {
            if (nextElement == null) {
                throw new NoSuchElementException("Yeet!");
            }

            T value = nextElement.getValue();
            nextElement = nextElement.getNextElement();
            return value;
        }


    }
}
