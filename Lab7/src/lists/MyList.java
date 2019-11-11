package lists;

import java.util.*;


/**
 * Class represents an array of Objects.
 *
 * @param <T> class to put into the list
 */
public class MyList<T> implements List<T> {

    /**
     * Inner structure of a list.
     */
    private DoublyLinkedList list;

    /**
     * Constructs an empty list.
     */

    public MyList() {
        this.list = new DoublyLinkedList<>();
    }

    /***
     * @param elements collection
     */
    public MyList(final Collection<T> elements) {
        this.list = new DoublyLinkedList<>(elements);
    }


    /**
     * Constructs a list with one element.
     *
     * @param element the head of the list
     */
    public MyList(final Object element) {
        this.list = new DoublyLinkedList(element);

    }


    /**
     * @return size of the list
     */
    public int size() {
        return this.list.size();
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
     * @return
     */

    public boolean add(final Object element) {

        return list.add((T) element);
    }



    @Override
    public boolean remove(Object o) {
        return this.remove(o);
    }

    /**
     * @return an array of MusicTracks
     */
    public T[] toArray() {
        if (list.size == 0) {
            return null;
        }

        T[] arr = (T[]) new Object[list.size];
        Iterator<T> iterator = list.iterator();
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
    public T get(final int position) throws IllegalArgumentException {
        return (T) list.get(position);
    }

    /**
     * @param position of the element to remove
     * @return
     * @throws IllegalArgumentException if the position exceeds the range
     */
    public T remove(final int position) throws IllegalArgumentException {

        return (T) list.remove(position);

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

    public boolean containsAll(final Collection<?> c) {
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
    public boolean addAll(final Collection c) {

        if (c == null) {
            return false;
        }

        for (Object e : c) {
            this.list.add((T) e);
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

        Iterator<Object> iterator = (Iterator<Object>) list.iterator();
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

        return list.set(index, (T) element);
    }


    /**
     * @param index   position to put an element to.
     * @param element to put.
     * @throws IllegalArgumentException if index is out of range
     */
    public void add(final int index,
                    final Object element) throws IllegalArgumentException {
        list.add(index, (T) element);

    }

    /**
     * @param index position to put elements on.
     * @param c     collection to get elements from
     * @return true if managed to add
     * @throws IllegalArgumentException if position is out of range
     */
    public boolean addAll(final int index, final Collection c)
            throws IllegalArgumentException {
        if (c == null) {
            return false;
        }

        int counter = index;

        for (Object element : c) {
            list.add(counter, (T) element);
            counter += 1;
        }

        return true;

    }


    /**
     * @param c collection of elements to be removed
     * @return true if the list changed
     */
    public boolean removeAll(final Collection<?> c) {
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

    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            return false;
        }

        Iterator<T> iterator = list.iterator();
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
    public Iterator<T> iterator() {
        return list.iterator();

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
    public void sort(final Comparator c) {
        T[] array = toArray();
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
        return (this == o) || ((o instanceof MyList) && list.equals(o));
    }


    /**
     * @param a array to put value to
     * @return array representing the list;
     */
    public T[] toArray(Object[] a) {
        if (a.length == 0) {
            return toArray();
        }

        if (a.length < size()) {
            a = (T[]) new Object[size()];
        }

        Iterator<T> iterator = list.iterator();
        int counter = 0;

        while (iterator.hasNext()) {
            a[counter++] = iterator.next();
        }

        return (T[]) a;
    }



    @Override
    public List subList(int i, int i1) {
        return new SubList(this, i, i1);
    }


    protected class SubList extends MyList {

        MyList parentList = null;
        int startPosition = 0;
        int endPosition = 0;

        public SubList(MyList parentList, int startPosition, int endPosition) {
            this.parentList = parentList;
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }

        public int size() {
            return endPosition - startPosition;
        }

        public void add(int index, Object object) {
            if(index > size()) {
                return;
            }

            parentList.add(index + startPosition, object);
        }

        public boolean contains(Object object) {
            for (int i = startPosition; i < endPosition; i++) {
                if (parentList.get(i).equals(object)) {
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            for (int i = 0; i + startPosition < endPosition; i++) {
                parentList.remove(startPosition + i);
            }

            startPosition = 0;
            endPosition = 0;
            parentList = null;
        }

    }



    @Override
    public int lastIndexOf(Object o) {
        if (list.head == null) {
            return -1;
        }

        Iterator<Object> iterator = (Iterator<Object>) list.iterator();
        int value = -1;
        int counter = 0;
        while (iterator.hasNext()) {
            if (iterator.next() == o) {
                value = counter;
            }
            counter++;
        }

        return value;
    }

    @Override
    public ListIterator<T> listIterator() {
        return (ListIterator<T>) list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return (ListIterator<T>) list.listIterator(i);
    }



}
