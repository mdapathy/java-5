package lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;


/**
 * Class represents an array of Objects.
 */
public class List<E> implements Iterable<E> {

    private DoublyLinkedList list;

    /**
     * Constructs an empty list.
     */

    public List() {
        this.list = new DoublyLinkedList<>();
    }

    /***
     * @param elements collection
     */
    public List(final Collection<E> elements) {
        this.list = new DoublyLinkedList<E>(elements);
    }


    /**
     * Constructs a list with one element.
     *
     * @param element the head of the list
     */
    public List(final Object element) {
        this.list = new DoublyLinkedList(element);

    }


    /**
     * @return size of the list
     */
    public int size() {
        return this.list.size;
    }


    /**
     * @return true if list has no elements
     */
    public boolean isEmpty() {
        return this.list.size == 0;
    }

    /**
     * Adds an element to the end of the list,
     * may as well add the first element.
     *
     * @param element element to add.
     */

    public void add(final Object element) {

        list.add(element);
    }


    /**
     * @return an array of MusicTracks
     */
    public E[] toArray() {
        if (list.size == 0) {
            return null;
        }

        E[] arr = (E[]) new Object[list.size];
        Iterator<E> iterator = list.iterator();
        int counter = 0;

        while (iterator.hasNext()) {
            arr[counter++] = iterator.next();
        }
        return arr;
    }


    /**
     * @param o object to compare
     * @return if this list contains the specified element.
     * More formally, returns true if and only if this list
     * contains at least one element e such that
     * (o==null ? e.element==null : o.equals(e.element)).
     */
    public boolean contains(final Object o) {
        return list.contains(o);
    }


    /**
     * @return list in the format of string
     * "element -> element -> ..."
     */
    public String toString() {
        return list.toString();

    }

    /**
     * @param position to look into
     * @return element
     * @throws IllegalArgumentException if the position is out of range
     */
    public E get(final int position) throws IllegalArgumentException {
        return (E) list.get(position);
    }

    /**
     * @param position of the element to remove
     * @throws IllegalArgumentException if the position exceeds the range
     */
    public Object remove(final int position) throws IllegalArgumentException {

        return list.remove(position);

    }

    /**
     * Clears the list.
     */
    public void clear() {
        list.clear();
    }

    /**
     * @param c collection of elements
     * @return true if contains all elements
     */
    public boolean containsAll(final Collection<Object> c) {
        if (c == null) {
            return false;
        }

        for (Object e : c) {
            if (!list.contains(e)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param c collection to take elements from
     * @return true if managed to add all
     */
    public boolean addAll(final Collection<Object> c) {

        if (c == null) {
            return false;
        }

        for (Object e : c) {
            this.list.add(e);
        }

        return true;

    }

    /**
     * @param element to look for
     * @return index of element or -1 if there is none
     */
    public int indexOf(final Object element) {
        if (list.head == null) {
            return -1;
        }

        Iterator<Object> iterator = list.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                return counter;
            }
            counter++;
        }

        return -1;

    }


    /**
     * @param index   to modify the element
     * @param element value to put at index's position.
     * @return the value that was modified
     * @throws IllegalArgumentException if index is out of range.
     */
    public Object set(final int index, final Object element)
            throws IllegalArgumentException {

        return list.set(index, element);
    }


    /**
     * @param index   position to put an element to.
     * @param element to put.
     * @throws IllegalArgumentException if index is out of range
     */
    public void add(final int index,
                    final Object element) throws IllegalArgumentException {
        list.add(index, element);

    }

    /**
     * @param index position to put elements on.
     * @param c     collection to get elements from
     * @return true if managed to add
     * @throws IllegalArgumentException if position is out of range
     */
    public boolean addAll(final int index, final Collection<Object> c)
            throws IllegalArgumentException {
        if (c == null) {
            return false;
        }

        int counter = index;

        for (Object element : c) {
            list.add(counter, element);
            counter += 1;
        }

        return true;

    }


    /**
     * @param c collection of elements to be removed
     * @return true if the list changed
     */
    public boolean removeAll(final Collection<Object> c) {
        if (c == null) {
            return false;
        }

        int sizeBefore = list.size;

        for (Object e : c) {
            int position = indexOf(e);
            while (position != -1) {
                remove(position);
                position = indexOf(e);
            }
        }
        return sizeBefore != list.size;
    }


    /**
     * @param c collection elements of which are to retain in the list.
     * @return true if the list changed
     */
    public boolean retainAll(final Collection<E> c) {
        if (c == null) {
            return false;
        }

        Iterator<E> iterator = list.iterator();
        int sizeBefore = list.size;
        int counter = 0;

        while (iterator.hasNext()) {

            if (!c.contains(iterator.next())) {
                remove(counter);
            } else {
                counter++;
            }
        }

        return sizeBefore != list.size;
    }

    /**
     * @return iterator over the elements of the list
     */
    public Iterator<E> iterator() {
        return (Iterator<E>) list.iterator();

    }

    /**
     * @return the hash code value for this list.
     */
    public int hashCode() {
        return list.hashCode();
    }

    /**
     * @param c comparator
     */
    public void sort(final Comparator<? super E> c) {
        E[] array = toArray();
        Arrays.sort(array, c);
        for (int counter = 0; counter < list.size; counter++) {
            set(counter, array[counter]);
        }

    }

    /**
     * @param o object to compare with
     * @return true if lists are identical
     */
    @Override
    public boolean equals(final Object o) {
        return (this == o) || ((o instanceof List) && this.list.equals(((List) o).list));
    }


    /**
     * @param a array to put value to
     * @return array representing the list;
     */
    public E[] toArray(E[] a) {
        if (a.length == 0) {
            return toArray();
        }

        if (a.length < size()) {
            a = (E[]) new Object[size()];
        }

        Iterator<E> iterator = list.iterator();
        int counter = 0;

        while (iterator.hasNext()) {
            a[counter++] = iterator.next();
        }

        return a;
    }


}
