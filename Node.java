/**
 * Represents a node in a linked list.
 *
 * @param <T> the type of value stored in the node
 */

class Node<T> {
    T value;
    Node<T> next;
    /**
     * Constructs a node with the specified value.
     *
     * @param data the value to be stored in the node
     */
    Node(T data) {
        value = data;
        next = null;
    }
}