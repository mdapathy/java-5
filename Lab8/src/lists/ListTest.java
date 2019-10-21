package lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void initializeEmptyList() {
        List<Object> list = new List<Object>();
        assertEquals(list.size(), 0);
    }

    @Test
    void initializeListWithASingleElement() {
        List<Object> list = new List<>(1);
        assertEquals(list.size(), 1);

    }

    @Test
    void initializeListWithACollectionOfElement() {
        List<Object> list = new List<>(Arrays.asList(1, 2, 3));
        assertEquals(list.size(), 3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    void givenEmptyListSizeShouldReturnZero() {
        List<Object> list = new List<>();
        assertEquals(list.size(), 0);
    }

    @Test
    void givenListWithElementSizeShouldReturnOne() {
        List<Object> list = new List<>(25);
        assertEquals(list.size(), 1);
    }


    @Test
    void givenListWithNullElementIsEmptyShouldReturnFalse() {
        List<Object> list = new List<Object>();
        list.add(null);
        assertFalse(list.isEmpty());
    }


    @Test
    void givenListWithAnElementSizeShouldReturnOne() {
        List<Object> list = new List<Object>(25);
        assertFalse(list.isEmpty());
    }


    @Test
    void addShouldAppendTheElement() {
        List<Object> list = new List<Object>(25);
        list.add(4);

        assertEquals(list.get(0), 25);
        assertEquals(list.get(1), 4);

    }

    @Test
    void toArrayOfEmptyListShouldReturnNull() {
        List<Object> list = new List<Object>();
        Object[] arr = list.toArray();
        assertNull(arr);

    }

    @Test
    void toArrayOfAListShouldReturnAnArrayOfElementsInTheSameOrder() {
        List<Object> list = new List<Object>(Arrays.asList(0, 1, 2, 3, 4));
        Object[] arr = list.toArray();
        assertEquals(5, arr.length);

        assertEquals(0, arr[0]);
        assertEquals(1, arr[1]);
        assertEquals(2, arr[2]);
        assertEquals(3, arr[3]);
        assertEquals(4, arr[4]);

    }

    @Test
    void containsShouldReturnTrueIfAnObjectIsInTheList() {
        List<Object> list = new List<Object>(Arrays.asList(0, 5));
        assertTrue(list.contains(0));
        assertTrue(list.contains(5));

        assertFalse(list.contains(null));
        assertFalse(list.contains("5"));

    }

    @Test
    void containsShouldReturnFalseIfAnObjectIsNotInTheList() {
        List<Object> list = new List<Object>(Arrays.asList(0, 5));
        assertFalse(list.contains(null));
        assertFalse(list.contains("5"));

    }

    @Test
    void toStringShouldReturnAProperString() {
        List<Object> list = new List<Object>(Arrays.asList(0, 15, 5, 1));
        String toString = list.toString();
        assertEquals(toString, "0 -> 15 -> 5 -> 1");

    }


    @Test
    void toStringOfAnEmptyListShouldReturnAnEmptyString() {
        List<Object> list = new List<Object>();
        String toString = list.toString();
        assertEquals(toString.length(), 0);

    }


    @Test
    void clearShouldReduceTheSizeOfListToZero() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertDoesNotThrow(list::clear);
        assertEquals(0, list.size());

    }


    @Test
    void getPositionOutOfRangeShouldThrowError() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.get(7), "Expected to throw an error when position is greater than the size");


        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.get(-1), "Expected to throw an error when position is negative");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void removeOutOfRangeShouldThrowError() {

        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.remove(7), "Expected to throw an error when position is greater than the size");


        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.remove(-1), "Expected to throw an error when position is negative");

        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));
    }

    @Test
    void testRemove() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        Object obj = list.remove(2);
        assertEquals(7, obj);
        assertEquals(8, list.get(2));

    }

    @Test
    void containsAllShouldReturnFalse() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertFalse(list.containsAll(Arrays.asList(1, 1, 11, 0)));
    }

    @Test
    void addAllOfNullShouldReturnFalse() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertFalse(list.addAll(null));
    }

    @Test
    void testContainsAll() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertTrue(list.containsAll(Arrays.asList(6, 6, 9, 7, 8)));

    }

    @Test
    void testAddAll() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertTrue(list.addAll(Arrays.asList(6, 1, 5, 7, 8)));

        assertEquals(10, list.size());
        assertEquals(6, list.get(5));
        assertEquals(1, list.get(6));
        assertEquals(5, list.get(7));
        assertEquals(7, list.get(8));
        assertEquals(8, list.get(9));

    }

    @Test
    void indexOfShouldReturnFirstIndex() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 5, 8, 6));
        assertEquals(0, list.indexOf(5));
        assertEquals(1, list.indexOf(6));

    }

    @Test
    void indexOfShouldReturnNegativeValueIfNotFound() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 5, 8, 6));
        assertEquals(-1, list.indexOf(10));
        assertEquals(-1, list.indexOf(null));

    }


    @Test
    void setPositionOutOfRangeShouldThrowError() {

        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.set(7, 5), "Expected to throw an error when position is greater than the size");


        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.set(-1, 5), "Expected to throw an error when position is greater than the size");


        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void setShouldChangeTheElement() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        Object obj = list.set(0, 1);

        assertEquals(5, obj);
        assertEquals(1, list.get(0));

    }

    @Test
    void addPositionOutOfRangeShouldThrowError() {

        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        ListException thrown1 =
                assertThrows(ListException.class,
                        () -> list.add(7, 5), "Expected to throw an error when position is greater than the size");


        ListException thrown2 =
                assertThrows(ListException.class,
                        () -> list.add(-1, 5), "Expected to throw an error when position is greater than the size");


        assertTrue(thrown1.getMessage().contains("out of range"));
        assertTrue(thrown2.getMessage().contains("out of range"));

    }

    @Test
    void testAdd() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        list.add(10);

        assertEquals(10, list.get(5));
        assertEquals(6, list.size());


    }

    @Test
    void removeAllOfShouldReturnFalseIfTheListDidNotChange() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertFalse(list.removeAll(Arrays.asList(19, 10, 11, 0)));
    }

    @Test
    void removeAllShouldDeleteAllOccurrences() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 5, 9, 9));
        assertTrue(list.removeAll(Arrays.asList(5, 9)));
        assertEquals(1, list.size());
        assertEquals(6, list.get(0));

    }

    @Test
    void retainAllShouldReturnFalseIfListDidNotChange() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertFalse(list.retainAll(Arrays.asList(5, 6, 8, 9, 7)));

    }

    @Test
    void retainAllShouldReturnFalseIfListChanged() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertTrue(list.retainAll(Arrays.asList(5, 5, 6)));
        assertEquals(2, list.size());

    }

    @Test
    void iteratorOverEmptyList() {
        List<Object> list = new List<Object>();
        Iterator<Object> iter = list.iterator();

        assertFalse(iter.hasNext());
    }

    @Test
    void testIteratorsNextMethodOverList() {

        List<Object> list = new List<Object>(Arrays.asList(1, 2));
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
    void hashCodeShouldReturnSameValueEachTime() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        assertEquals(list.hashCode(), list.hashCode());

    }

    @Test
    void hashCodeShouldReturnSameValueForIdenticalObjects() {
        List<Object> list1 = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        List<Object> list2 = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));

        assertEquals(list1.hashCode(), list2.hashCode());

    }


    @Test
    void equalsOfIdenticalObjectShouldReturnTrue() {
        List<Object> list1 = new List<Object>(Arrays.asList(1, 2, 3));
        List<Object> list2 = new List<Object>(Arrays.asList(1, 2, 3));

        assertEquals(list1, list2);
    }


    @Test
    void sortListShouldChangeTheList() {
        List<Object> list1 = new List<Object>(Arrays.asList(3, 1, 2));
        list1.sort(Comparator.comparingInt(t -> (Integer) t));
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list1.get(2));


    }


    @Test
    void testToArrayWithArrayOfSmallerSize() {

        List<Object> list = new List<Object>(Arrays.asList(1, 2, 3, 4));
        Object[] arr = new Object[1];

        arr = list.toArray(arr);
        assertEquals(4, arr.length);
    }


    @Test
    void testToArrayWithArrayOfGreaterSize() {

        List<Object> list = new List<Object>(Arrays.asList(1, 2, 3, 4));
        Object[] arr = new Object[10];

        arr = list.toArray(arr);
        assertEquals(10, arr.length);
        assertNull(arr[4]);

    }


    @Test
    void addAllOfShouldReturnFalseIfTheListDidNotChange() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8, 9));
        assertFalse(list.addAll(null));
    }

    @Test
    void addAllShouldDeleteAllOccurrences() {
        List<Object> list = new List<Object>(Arrays.asList(5, 6, 7, 8));
        assertTrue(list.addAll(Arrays.asList(5, 4)));
        assertEquals(6, list.size());
        assertEquals(5, list.get(4));
        assertEquals(4, list.get(5));

    }

}