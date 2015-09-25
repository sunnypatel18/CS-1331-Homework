/**
 * This class performs Array Wrapper and implements SimpleCollection
 * @author Sunny Patel
 * @version 1.0
 */
public class ArrayWrapper<T> implements SimpleCollection<T> {
    private T[] arr;

    public ArrayWrapper() {
        arr = (T[]) new Object[5];
    }

    /**
     * Adds an element into the collection.
     * If the new element would exceed the size of the backing array,
     * instead resize the array, doubling it in size and copy over the
     * old elements.
     *
     * @param elem The element being added.
     */
    public void add(T elem) {
        if (size() == capacity()) {
            T[] arrCopy = (T[]) new Object[capacity() * 2];
            int i = 0;
            for (T el : arr) {
                arrCopy[i] = el;
                i++;
            }
            arr = arrCopy;
        }
        arr[size()] = elem;
    }

    /**
     * Adds all elements in elems to the collection.
     * Hint: can this be implemented in terms of add(T elem)?
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (T elem : elems) {
            add(elem);
        }
    }

    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous. For example:
     *
     * Collection = ["hi", "hello", "wsup", "hey", null]
     * Collection after remove("hello") = ["hi", "wsup", "hey", null, null]
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        boolean found = false;
        int size = size();
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(elem)) {
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = null;
                found = true;
            }
        }
        return found;
    }

    /**
     * Removes each element in elems from the collection.
     * Hint: can this be implemented in terms of remove(T elem)?
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        boolean found = false;
        for (T elem : elems) {
            found = remove(elem) ? true : found;
        }
        return found;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        int i = 0;
        while (i < size() && arr[i] != null) {
            if (arr[i].equals(elem)) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (index >= size()) {
            throw new java.util.NoSuchElementException();
        }
        return (T) arr[index];
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int i = 0;
        while (i < capacity() && arr[i] != null) {
            i++;
        }
        return i;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return arr.length;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        arr = (T[]) new Object[5];
    }

    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * While having toString be defined in the interface doesn't force you
     * to override the method in the implementing class, the format we
     * expect the toString() is as follows:
     *
     * [element1, element2, element3, ..., elementN]
     *
     * The end of the list should not contain any nulls, even if the
     * backing array is larger than the number of elements.
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String out = "[";
        int i = 0;
        while (arr[i] != null && i < capacity()) {
            out += arr[i] + ", ";
            i++;
        }
        if (out.length() > 1) {
            out = out.substring(0, out.length() - 2);
        }
        return out + "]";
    }
}