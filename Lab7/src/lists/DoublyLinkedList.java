package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class represents lists.List which inner structure is doubly-linked list.
 *
 * @param <E> type of the element stored.
 */
public class DoublyLinkedList<E> implements Iterable<E> {

    /**
     * Class represents a node of the list.
     */
    protected class Node {
        /**
         * the list element.
         */
        private E element;
        /**
         * the previous element.
         */
        private Node prev;
        /**
         * the next element.
         */
        private Node next;

        /**
         * @param node element
         * @param prev previous node
         * @param next next node
         */
        Node(final E node, final Node prev, final Node next) {
            this.element = node;
            this.prev = prev;
            this.next = next;
        }

    }

    /**
     * The head of the list.
     */
    protected Node head;
    /**
     * The tail of the list.
     */
    protected Node tail;
    /**
     * The size of the list.
     */
    protected int size;

    /**
     * Constructs an empty list.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a list with one element.
     *
     * @param element the head of the list
     */
    public DoublyLinkedList(final E element) {
        Node head = new Node(element, null, null);
        this.head = head;
        this.tail = head;
        this.size = 1;

    }

    /**
     * Constructs a list consisting of elements of collection.
     *
     * @param elements collection of elements
     */
    public DoublyLinkedList(final Collection<E> elements) {
        for (E element : elements) {
            this.add(element);
        }
    }

    /**
     * @return size of the list
     */
    public int size() {
        return this.size;
    }


    /**
     * Adds an element to the end of the list,
     * may as well add the first element.
     *
     * @param element element to add.
     */
    public boolean add(final E element) {

        Node temp = new Node(element, this.tail, null);

        if (this.tail != null) {
            tail.next = temp;
            this.tail = temp;
        } else {
            this.head = temp;
            this.tail = temp;
        }

        size++;
        return true;
    }


    /**
     * @param index   position to put an element to.
     * @param element to put.
     * @throws IllegalArgumentException if index is out of range
     */
    public void add(final int index,
                    final E element) throws IllegalArgumentException {

        if (index == size) {
            add(element);
            return;
        }

        Node toPlace = new Node(element, null, null);

        if (index == 0) {
            head.prev = toPlace;
            toPlace.next = head;
            head = toPlace;
            size++;
        } else {

            Node prev = getNodeAtPosition(index - 1);
            Node next = prev.next;

            prev.next = toPlace;
            next.prev = toPlace;

            toPlace.next = next;
            toPlace.prev = prev;

            size++;
        }

    }

    /**
     * @param o object to compare
     * @return if this list contains the specified element.
     * More formally, returns true if and only if this list
     * contains at least one element e such that
     * (o==null ? e.element==null : o.equals(e.element)).
     */
    public boolean contains(final Object o) {

        Node tmp = this.head;

        while (tmp != null) {
            if ((o == null && tmp.element == null)
                    || o != null && o.equals(tmp.element)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * @param position to get element from
     * @return the element or null
     */
    private Node getNodeAtPosition(final int position) {
        if (position >= size || size == 0 || position < 0) {
            throw new IllegalArgumentException(
                    "Position in the list out of range");
        }

        Node tmp = head;
        for (int i = 0; i < position; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }


    /**
     * @return list in the format of string
     * "element -> element -> ..."
     */
    public String toString() {

        StringBuilder result = new StringBuilder();
        DoublyLinkedList.Node temp = this.head;

        if (temp != null) {
            result.append(temp.element.toString());
            temp = temp.next;
        }
        while (temp != null) {
            result.append(" -> ").append(temp.element.toString());
            temp = temp.next;
        }
        return result.toString();

    }

    /**
     * @param position to look into
     * @return element
     * @throws IllegalArgumentException if the position is out of range
     */
    public E get(final int position) throws IllegalArgumentException {
        return getNodeAtPosition(position).element;
    }

    /**
     * @param position of the element to remove
     * @return E element that was removed
     * @throws IllegalArgumentException if the position exceeds the range
     */
    public E remove(final int position) throws IllegalArgumentException {


        if (size == 1) {
            E tmp = head.element;
            head = null;
            tail = null;
            return tmp;
        }
        Node tmp = getNodeAtPosition(position);

        size--;

        if (position == size) {
            tail = tail.prev;
            tail.next = null;

        } else if (position == 0) {
            head = head.next;
            head.prev = null;
        } else {
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }

        return tmp.element;

    }

    /**
     * @return iterator for the list
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node tmp = new Node(null, null, head);

            @Override
            public boolean hasNext() {
                return tmp.next != null;
            }

            @Override
            public E next() {
                tmp = tmp.next;
                return tmp.element;
            }

            public boolean hasPrevious() {
                return tmp.prev != null;
            }

            public E previous() {
                tmp = tmp.prev;
                return tmp.element;
            }


        };

    }

    /**
     * @param index   to modify the element
     * @param element value to put at index's position.
     * @return the value that was modified
     * @throws IllegalArgumentException if index is out of range.
     */
    public E set(final int index, final E element)
            throws IllegalArgumentException {

        Node tmp = getNodeAtPosition(index);
        E toReturn = tmp.element;
        tmp.element = element;

        return toReturn;
    }


    /**
     * @return the hash code value for this list.
     */
    public int hashCode() {
        int hashCode = 1;
        final int i = 31;
        Node tmp = head;

        while (tmp != null) {
            hashCode = i * hashCode + (
                    tmp.element == null ? 0 : tmp.element.hashCode());
            tmp = tmp.next;
        }

        return hashCode;
    }

    /**
     * @param o object to compare with
     * @return true if lists are identical
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }

        if (o != null && getClass() == o.getClass()
                && ((DoublyLinkedList) o).size == size) {
            Node tmp1 = head;

            DoublyLinkedList.Node tmp2 = ((DoublyLinkedList) o).head;

            while (tmp1 != null && tmp2 != null) {
                if (tmp1.element != tmp2.element) {
                    return false;
                }
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
            return true;
        }
        return false;
    }

    /**
     * Clears the list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public ListIterator<E> listIterator() {
        return new ListIterator<>() {
            private Node current = head;
            int counter = 0;

            @Override
            public boolean hasNext() {
                return current != null;
            }


            public E next() {
                Node temp = current;
                current = current.next;
                counter++;
                return (E) temp.element;
            }

            @Override
            public boolean hasPrevious() {
                return current != null;
            }

            @Override
            public E previous() {
                current = current.prev;
                counter--;
                return (E) current.element;
            }


            @Override
            public int nextIndex() {
                return counter;
            }

            @Override
            public int previousIndex() {
                return counter - 1;
            }

            @Override
            public void remove() {
                DoublyLinkedList.this.remove(current);
            }

            @Override
            public void set(E e) {
                DoublyLinkedList.this.set(counter, e);

            }

            @Override
            public void add(E e) {
                DoublyLinkedList.this.set(counter - 1, e);

            }


        };

    }

    public ListIterator<E> listIterator(int pos) {
        return new ListIterator<>() {
            private Node current = getNodeAtPosition(pos);
            int counter = pos;


            @Override
            public boolean hasNext() {
                return current != null;
            }


            public E next() {
                Node temp = current;
                current = current.next;
                return (E) temp.element;
            }

            @Override
            public boolean hasPrevious() {
                return current != null;
            }

            @Override
            public E previous() {
                current = current.prev;
                counter--;
                return (E) current.element;
            }


            @Override
            public int nextIndex() {
                return counter;
            }

            @Override
            public int previousIndex() {
                return counter - 1;
            }

            @Override
            public void remove() {
                DoublyLinkedList.this.remove(current);
            }

            @Override
            public void set(E e) {
                DoublyLinkedList.this.set(counter, e);

            }

            @Override
            public void add(E e) {
                DoublyLinkedList.this.set(counter - 1, e);

            }
        };

    }

    public boolean remove(Object o) {

        int tmp = findPosition(o);

        if (tmp != -1) {
            remove(tmp);
            return true;
        }

        return false;

    }



    private int findPosition(Object o) {
        Node tmp = head;

        for (int i = 0; tmp!= null; i++) {
            if (tmp.element.equals(o)) {
                return i;
            }
            tmp = tmp.next;
        }

        return -1;

    }

}
