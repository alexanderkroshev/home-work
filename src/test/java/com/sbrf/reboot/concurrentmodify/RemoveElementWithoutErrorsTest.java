package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveElementWithoutErrorsTest {

    List<Integer> list;
    List<Integer> list2 = new ArrayList(Arrays.asList(2, 3));

    @BeforeEach
    void init() {
        list = new ArrayList(Arrays.asList(1, 2, 3));
    }

    @Test
    public void successConcurrentModificationException() {

        assertThrows(ConcurrentModificationException.class, () -> {

            for ( Integer integer : list ) {
                list.remove(1);
            }

        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {

        Integer integer;
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            integer = iterator.next();
            if (integer == 1)
                iterator.remove();
        }

        assertEquals(list, list2);
    }

    @Test
    public void successRemoveElementWithoutErrors2() {

        list.removeIf(i -> i == 1);

        assertEquals(list, list2);
    }

    @Test
    public void successRemoveElementWithoutErrors3() {

        list = list.stream().filter(i -> i != 1).collect(Collectors.toList());

        assertEquals(list, list2);
    }

}
