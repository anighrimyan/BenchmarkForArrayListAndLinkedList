/**
 * Represents a dynamic array implementation called ArrayList.
 *
 * @param <T> the type of elements stored in the ArrayList
 */
public class ArrayList<T> {
    private T[] array;
    private int size;
    private int indexOfLastElement;

    /**
     * Constructs an ArrayList with the specified initial capacity.
     *
     * @param sizeOfArrayList the initial capacity of the ArrayList
     */
    public ArrayList(int sizeOfArrayList) {
        this.size = sizeOfArrayList;
        Object[] tempArray = new Object[size];
        array = (T[]) tempArray;
        tempArray = null;
    }

    /**
     * Constructs an ArrayList with an initial capacity of 10.
     */
    public ArrayList() {
        this(10);
    }


    /**
     * Adds an element to the end of the ArrayList.
     *
     * @param element the element to be added
     */
    public void addElement(T element) {
        if (size == array.length) {
            int num = 10 + size;
            reSize(num);
            size = array.length;
        }
        array[indexOfLastElement + 1] = element;
    }

    /**
     * Sets the element at the specified index to the given element.
     *
     * @param index   the index of the element to be set
     * @param element the new element to be set
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void setElement(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    /**
     * Resizes the internal array of the ArrayList to the specified new size.
     *
     * @param newSize the new size of the internal array
     */
    private void reSize(int newSize) {
       // T[] newArray = (T[]) new Object[newSize];
        T[] tmp = array;
        array = (T[]) new Object[newSize];
        if (size >= 0)
            System.arraycopy(tmp, 0, array, 0, size);
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        indexOfLastElement--;
        if (indexOfLastElement <= array.length / 4) {
            reSize(array.length / 2);
            size = array.length;
        }
    }
    /**
     * Returns the length (number of elements) of the ArrayList.
     *
     * @return the length of the ArrayList
     */
    public int length() {
        return size;
    }
}
