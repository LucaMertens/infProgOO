package examples.stack;

/**
 * StackElement
 */
public class StackElement<T> {
    private T value;
    private StackElement<T> nextElement;

    public StackElement(T value, StackElement<T> nextElement) {
        this.value = value;
        this.nextElement = nextElement;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @return the nextElement
     */
    public StackElement<T> getNext() {
        return nextElement;
    }
}
