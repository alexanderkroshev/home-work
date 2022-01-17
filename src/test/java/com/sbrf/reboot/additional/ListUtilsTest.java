package com.sbrf.reboot.additional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUtilsTest {

    private final List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3));
    private final List<String> emptyList = new ArrayList<>();

    @Test
    void getFirst() {
        assertEquals(integerList.get(0), ListUtils.getFirst(integerList).get());
    }

    @Test
    void getFirstFromEmptyList() {
        assertEquals(Optional.empty(), ListUtils.getFirst(emptyList));
    }

    @Test
    void getLast() {
        assertEquals(integerList.get(integerList.size() - 1), ListUtils.getLast(integerList).get());
    }

    @Test
    void getLastFromEmptyList() {
        assertEquals(Optional.empty(), ListUtils.getLast(emptyList));
    }

}