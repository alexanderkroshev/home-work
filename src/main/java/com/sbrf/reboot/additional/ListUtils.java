package com.sbrf.reboot.additional;

import java.util.List;

public class ListUtils {

    public static <T> T getFirst(List<T> list) {
        return list.get(0);
    }

    public static <T> T getLast(List<T> list) {
        return list.get(list.size() - 1);
    }

}
