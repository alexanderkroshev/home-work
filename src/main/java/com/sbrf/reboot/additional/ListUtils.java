package com.sbrf.reboot.additional;

import java.util.List;
import java.util.Optional;

public class ListUtils {

    public static <T> Optional<T> getFirst(List<T> list) {
        return Optional.ofNullable(list.get(0));
    }

    public static <T> Optional<T> getLast(List<T> list) {
        return Optional.ofNullable(list.get(list.size()-1));
    }

}
