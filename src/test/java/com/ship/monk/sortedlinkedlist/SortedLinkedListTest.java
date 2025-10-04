package com.ship.monk.sortedlinkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortedLinkedListTest {

    @Test
    public void testInsertsOfIntegers() {
        var integerLinkedList = new SortedLinkedList<Integer>();
        integerLinkedList.add(2);
        integerLinkedList.add(1);
        integerLinkedList.add(5);
        integerLinkedList.add(6);
        integerLinkedList.add(2);
        integerLinkedList.add(4);

        var integerArrayList = integerLinkedList.toList();
        Assertions.assertThat(integerArrayList).isPresent();

        Assertions.assertThat(integerArrayList.get()).containsExactly(1, 2, 2, 4, 5, 6);
    }

    @Test
    public void testInsertsOfStrings() {
        var stringLinkedList = new SortedLinkedList<String>();
        stringLinkedList.add("afc");
        stringLinkedList.add("abc");
        stringLinkedList.add("adf");
        stringLinkedList.add("add");
        stringLinkedList.add("adc");
        stringLinkedList.add("cba");

        var stringArrayList = stringLinkedList.toList();
        Assertions.assertThat(stringArrayList).isPresent();

        Assertions.assertThat(stringArrayList.get()).containsExactly("abc", "adc", "add", "adf", "afc", "cba");
    }

    @Test
    public void testInsertsAndDeletionsOfInteger() {
        var integerLinkedList = new SortedLinkedList<Integer>();
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(4);
        integerLinkedList.add(5);
        integerLinkedList.add(3);

        var integerArrayList = integerLinkedList.toList();
        Assertions.assertThat(integerArrayList).isPresent();

        Assertions.assertThat(integerArrayList.get()).containsExactly(1, 2, 3, 4, 5);

        integerLinkedList.remove(5);

        integerArrayList = integerLinkedList.toList();
        Assertions.assertThat(integerArrayList).isPresent();
        Assertions.assertThat(integerArrayList.get()).containsExactly(1, 2, 3, 4);

        integerLinkedList.add(5);

        integerArrayList = integerLinkedList.toList();
        Assertions.assertThat(integerArrayList).isPresent();
        Assertions.assertThat(integerArrayList.get()).containsExactly(1, 2, 3, 4, 5);

        integerLinkedList.remove(2);
        integerLinkedList.remove(5);
        integerLinkedList.add(6);

        integerArrayList = integerLinkedList.toList();
        Assertions.assertThat(integerArrayList).isPresent();
        Assertions.assertThat(integerArrayList.get()).containsExactly(1, 3, 4, 6);
    }

    @Test
    public void testOfNullInsertion() {
        var stringLinkedList = new SortedLinkedList<String>();
        stringLinkedList.add("abc");
        assertThrows(NullPointerException.class,
                () -> stringLinkedList.add(null));
    }

    @Test
    public void testOfRemoveNullValue() {
        var stringLinkedList = new SortedLinkedList<String>();
        assertThrows(NullPointerException.class,
                () -> stringLinkedList.remove(null));
    }

    @Test
    public void testOfNotPresentArrayList() {
        var stringLinkedList = new SortedLinkedList<String>();
        assertThat(!stringLinkedList.toList().isPresent());
    }

}
