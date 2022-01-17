package com.sbrf.reboot.additional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUtilsTest {

    private final List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, null));
    private final List<String> stringList = new ArrayList<>(Arrays.asList(null, "cde", "efg"));
    private final List<String> emptyList = new ArrayList<>();


    @Test
    void getFirst() {
        assertEquals(integerList.get(0), ListUtils.getFirst(integerList).get());
    }

    @Test
    void getFirstOfEmptyList() {
        assertEquals(Optional.empty(), ListUtils.getFirst(emptyList));
    }


    @Test
    void getLast() {
        assertEquals(stringList.get(stringList.size() - 1), ListUtils.getLast(stringList).get());
    }

    @Test
    void getLastOfEmptyList() {
        assertEquals(Optional.empty(), ListUtils.getLast(emptyList));
    }

}