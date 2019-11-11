package lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedMyListTest {

    @Test
    void testCreatingAnEmptyDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(0, list.size);
        assertNull(list.head);
        assertNull(list.tail);

    }

    @Test
    void testCreatingADoublyLinkedListWithOneElementShouldNotThrowAnError() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(6);
        assertEquals(1, list.size);
        assertEquals(6, list.head.element);
        assertEquals(6, list.tail.element);

        assertNull(list.tail.next);
        assertNull(list.tail.prev);


    }

    @Test
    void creatingADoublyLinkedListViaCollectionShouldNotThrowAnError() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(4, 5, 6, 7));
        assertEquals(4, list.size);

        assertEquals(4, list.head.element);
        assertEquals(5, list.head.next.element);
        assertEquals(6, list.head.next.next.element);
        assertEquals(6, list.tail.prev.element);
        assertEquals(7, list.tail.element);
    }


    @Test
    void addAddNullElementShouldNotThrowError() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(4, 5, 6));
        list.add(null);

        assertEquals(4, list.size);
        assertNull(list.tail.element);

    }


    void addHeadToTheList() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        list.add(11);

        assertEquals(11, list.head.element);
        assertEquals(11, list.tail.element);

    }

    @Test
    void addElementToTheList() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(4, 5, 6));

        list.add(7);
        list.add(8);

        assertEquals(5, list.size);
        assertEquals(8, list.tail.element);
        assertEquals(7, list.tail.prev.element);

    }

    @Test
    void addWithPositionOutOfRangeShouldThrowAnError() {
        DoublyLinkedList<Object> emptyList = new DoublyLinkedList<Object>(6);

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> emptyList.add(2, 5), "Expected to throw an error when position is greater than the size");


        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> emptyList.add(-1, 5), "Expected to throw an error when position is negative");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void testAddWithPositionTail() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(8);

        list.add(1, 9);

        assertEquals(9, list.head.next.element);
        assertEquals(9, list.tail.element);
    }

    @Test
    void testAddWithPositionHead() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();

        list.add(0, 9);

        assertEquals(9, list.head.element);
        assertEquals(9, list.tail.element);
    }

    @Test
    void testAddWithPosition() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        list.add(3, 4);
        list.add(4, 5);

        assertEquals(4, list.tail.prev.element);
        assertEquals(5, list.tail.element);

    }

    @Test
    void containsNullShouldReturnTrueIfThereIsANullElement() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        list.add(null);

        assertNull(list.tail.element);
        assertTrue(list.contains(null));
    }

    @Test
    void containsShouldReturnFalseForEmptyList() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        assertFalse(list.contains(null));
        assertFalse(list.contains(5));


    }

    @Test
    void testContains() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));

    }

    @Test
    void toStringOfEmptyLIstShouldReturnAnEmptyString() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        String toStr = list.toString();
        assertEquals("", toStr);
    }


    @Test
    void toStringShouldReturnExpectedString() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        String toStr = list.toString();
        assertEquals("1 -> 2 -> 3", toStr);

    }

    @Test
    void getPositionOutOfRangeShouldThrowError() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.get(5), "Expected to throw an error when position is greater than the size");

        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.get(-1), "Expected to throw an error when position is greater than the size");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void removeHeadShouldChangePointerToHead() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        list.remove(0);

        assertEquals(2, list.size);
        assertEquals(2, list.head.element);
        assertNull(list.head.prev);

    }

    @Test
    void removeTailShouldChangePointerToTail() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        list.remove(2);

        assertEquals(2, list.size);
        assertEquals(2, list.tail.element);
        assertNull(list.tail.next);
    }

    @Test
    void removeElementShouldChangeConnectionsBetweenElements() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        list.remove(1);

        assertEquals(2, list.size);
        assertEquals(1, list.tail.prev.element);
        assertEquals(3, list.head.next.element);

    }

    @Test
    void removeShouldThrowErrorIfPositionIsOutOfRange() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.remove(5), "Expected to throw an error when position is greater than the size");

        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.remove(-1), "Expected to throw an error when position is greater than the size");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));
    }


    @Test
    void iteratorOverEmptyList() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        Iterator<Object> iter = list.iterator();

        assertFalse(iter.hasNext());
    }

    @Test
    void testIteratorsNextMethodOverList() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2));
        Iterator<Object> iter = list.iterator();
        assertTrue(iter.hasNext());

        Object obj = iter.next();
        assertEquals(1, obj);

        assertTrue(iter.hasNext());

        obj = iter.next();
        assertEquals(2, obj);

        assertFalse(iter.hasNext());

    }


    @Test
    void setShouldThrowErrorWhenPositionIsOutOfRange() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.set(5, 1), "Expected to throw an error when position is greater than the size");

        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.set(-1, 1), "Expected to throw an error when position is greater than the size");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void setShouldChangeTheElement() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        Object obj = list.set(1, 6);

        assertEquals(obj, 2);
        assertEquals(6, list.get(1));

    }

    @Test
    void hashCodeShouldReturnSameValueEachTime() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        assertEquals(list.hashCode(), list.hashCode());

    }

    @Test
    void hashCodeShouldReturnSameValueForIdenticalObjects() {
        DoublyLinkedList<Object> list1 = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        DoublyLinkedList<Object> list2 = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        assertEquals(list1.hashCode(), list2.hashCode());

    }


    @Test
    void equalsOfIdenticalObjectShouldReturnTrue() {
        DoublyLinkedList<Object> list1 = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        DoublyLinkedList<Object> list2 = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        assertEquals(list1, list2);
    }


    @Test
    void testClear() {
        DoublyLinkedList<Object> list1 = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        list1.clear();

        assertEquals(0, list1.size);
        assertNull(list1.head);
        assertNull(list1.tail);


    }


    @Test
    void listIteratorOverEmptyList() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
        ListIterator<Object> iter = list.listIterator();

        assertFalse(iter.hasNext());
    }

    @Test
    void testListIteratorsNextMethodOverList() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2));
        ListIterator<Object> iter = list.listIterator();
        assertTrue(iter.hasNext());

        Object obj = iter.next();
        assertEquals(1, obj);

        assertTrue(iter.hasNext());

        obj = iter.next();
        assertEquals(2, obj);

        assertFalse(iter.hasNext());


    }

    @Test
    void listIteratorPositionOurOfRangeShouldThrowError() {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        assertThrows( ListException.class, () -> list.listIterator(5));
        assertThrows( ListException.class, () -> list.listIterator(-1));

    }

    @Test
    void testListIteratorsPreviousMethodOverList() {

        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        ListIterator<Object> iter = list.listIterator(2);

        assertTrue(iter.hasPrevious());

        Object obj = iter.previous();
        assertEquals(2, obj);

        assertTrue(iter.hasNext());

        obj = iter.previous();
        assertEquals(1, obj);


    }


    @Test
    void removeObjectShouldReturnFalseIfNoSuchObjectPresent()
    {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));

        assertFalse(list.remove(new Integer(5)));
    }

    @Test
    void removeObjectShouldReturnTrueIfObjectRemoved()
    {
        DoublyLinkedList<Object> list = new DoublyLinkedList<Object>(Arrays.asList(1, 2, 3));
        assertTrue(list.remove(new Integer(1)));
        assertEquals(2, list.get(0));


    }


}