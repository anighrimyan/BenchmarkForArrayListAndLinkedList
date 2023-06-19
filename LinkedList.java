/**
 * Represents a generic linked list.
 *
 * @param <T> the type of elements stored in the list
 */
class List<T> {
    Node<T> head;
    private int length = 0;

    /**
     * Constructs an empty list.
     */
    List() {
        head = null;
    }

    /**
     * Returns the length of the linked list.
     *
     * @return the number of elements in the linked list
     */
    int list_length() {
        if (empty()) {
            return 0;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            ++length;
        }
        return length;
    }

    /**
     * Adds a new node with the specified data to the end of the linked list.
     *
     * @param data the data to be stored in the new node
     */
    void add_Node(T data) {
        Node<T> temp = new Node<>(data);
        if (empty()) {
            head = temp;
            System.out.println("The list has created.");
            ++length;
        } else {
            Node<T> ref = head;
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = temp;
            ++length;
        }
    }

    /**
     * Adds a new node with the specified data at the specified position in the linked list.
     *
     * @param pos  the position at which to add the node
     * @param data the data to be stored in the new node
     */
    void add_Node(int pos, T data) {
        if (!empty()) {
            return;
        }
        if (pos > list_length() + 1) {
            System.out.println("Error: Position unavailable in LinkedList.");
            return;
        }
        if (pos == 1) {
            Node<T> temp = head;
            head = new Node<>(data);
            head.next = temp;
            return;
        }
        Node<T> temp = head;
        Node<T> prev = head;
        while (pos - 1 > 0) {
            prev = temp;
            temp = temp.next;
            --pos;
        }
        prev.next = new Node<>(data);
        prev.next.next = temp;
    }

    /**
     * Removes the node with the specified key from the linked list.
     *
     * @param key the value to be removed from the list
     */
    void remove_Node(T key) {
        if (!empty()){
            return;
        }
        if (key == head.value) {
            head = head.next;
            return;
        }
        Node<T> temp = head.next;
        Node<T> prev = head;
        while (temp.next != null) {
            if (temp.value == key) {
                prev.next = temp.next;
            }
        }
    }

    /**
     * Clears the linked list by removing all nodes.
     */
    void clear() {
        head = null;
        length = 0;
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    boolean empty() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return true;
        }
        return false;
    }

    /**
     * Creates a new linked list with a single node containing the specified data.
     *
     * @param data the data to be added to the new linked list
     */
    void list_create(T data) {
        add_Node(data);
    }

    /**
     * Swaps the values of two nodes at the specified indices in the given list.
     *
     * @param list   the list in which the swap operation is performed
     * @param index1 the index of the first node to be swapped
     * @param index2 the index of the second node to be swapped
     * @return true if the swap operation is successful, false otherwise
     */
    boolean swap(List<T> list, int index1, int index2) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        if (index1 < 0 || index2 < 0 || index1 > length || index2 > length ) {
            System.out.println("Error: Invalide parametr.");
            return false;
        }
        Node<T> temp = null;
        Node<T> ptr = head;
        T tmp;
        if (index1 != index2) {
            while (index1 != 0 || index2 != 0) {
                if (index1 != 0 && index2 != 0) {
                    temp = ptr;
                }
                --index1;
                --index2;
                ptr = ptr.next;
            }
            tmp = ptr.value;
            ptr.value = temp.value;
            temp.value = tmp;
            return true;
        }
        return false;
    }
}


