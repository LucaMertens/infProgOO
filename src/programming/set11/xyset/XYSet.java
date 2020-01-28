package programming.set11.xyset;

/**
 * Classes that implement this interface represent a collection of values of
 * which none may appear twice. Elements of an {@link XYSet} do not necessarily
 * have a specific order. The methods this set supports are deviously inspired
 * by the methods supported by Java's own {@link java.util.Set Set} interface.
 */
public interface XYSet<E> {

	/**
	 * Adds an element to the set if it is not already part of the set.
	 * 
	 * @param element
	 *            the element to be added.
	 * @return {@code true} if the element was added to the set, {@code false} if
	 *         the element was already part of the set.
	 * @throws NullPointerException
	 *             if {@code element} is {@code null}.
	 */
	boolean add(E element);

	/**
	 * Removes an element from the set if it is part of it.
	 * 
	 * @param element
	 *            the element to be removed.
	 * @return {@code true} if the element was in the set, {@code false} if it was
	 *         not.
	 * @throws NullPointerException
	 *             if {@code element} is {@code null}.
	 */
	boolean remove(E element);

	/**
	 * Checks whether the given element is part of the set.
	 * 
	 * @param element
	 *            the element to look for.
	 * @return {@code true} if the element is part of the set.
	 * @throws NullPointerException
	 *             if {@code element} is {@code null}.
	 */
	boolean contains(E element);

	/**
	 * Removes all elements from the set.
	 */
	void clear();

	/**
	 * Returns the number of elements in the set.
	 * 
	 * @return the size of the set.
	 */
	int size();

}
