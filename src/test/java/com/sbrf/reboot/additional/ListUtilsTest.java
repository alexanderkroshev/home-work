package com.sbrf.reboot.additional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {

    private final List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));
    private final List<String> stringList = new ArrayList<>(Arrays.asList("abc","cde","efg"));


    @Test
    void getFirst() {
        assertEquals(integerList.get(0), ListUtils.getFirst(integerList));
    }

    @Test
    void getLast() {
        assertEquals(stringList.get(0), ListUtils.getFirst(stringList));
    }

}