package programming.set11.xyset;

import java.util.LinkedList;

/**
 * ExcellentXYSet
 */
public class ExcellentXYSet<E> implements XYSet<E> {
    private LinkedList<E> content;

    public ExcellentXYSet() {
        content = new LinkedList<E>();
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("The input was null.");
        }

        if (this.contains(element)) {
            return false;
        }

        // If the program got here, the element wasn't already in the set.
        content.add(element);
        return true;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            throw new IllegalArgumentException("The input was null.");
        }
        return content.remove(element);
    }

    @Override
    public boolean contains(E element) {
        if (element == null) {
            throw new IllegalArgumentException("The input was null.");
        }
        return content.contains(element);
    }

    @Override
    public void clear() {
        content.clear();
    }

    @Override
    public int size() {
        return content.size();
    }

}
