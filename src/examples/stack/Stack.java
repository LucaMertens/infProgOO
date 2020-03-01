package examples.stack;

/**
 * stack
 */
public class Stack<T> {
    StackElement<T> firstElement = null;

    public void push(T element) {
        firstElement = new StackElement<T>(element, firstElement);
    }

    public T pop() {
        if (firstElement == null) {
            return null;
        }
        T value = firstElement.getValue();

        firstElement = firstElement.getNext();

        return value;
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.pop();
        test.push(2);
        test.push(34);
        System.out.println(test.pop());
        System.out.println(test.pop());
    }

}
