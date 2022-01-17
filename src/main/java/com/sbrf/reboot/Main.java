package com.sbrf.reboot;

import com.sbrf.reboot.additional.ListUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> ints = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        List<String> stringList = new ArrayList<String>() {{
            add(null);
            add("abc");
            add("cde");
        }};

        List<String> list = new ArrayList<>();

        System.out.println(ListUtils.getFirst(stringList));
//        System.out.println(ListUtils.getFirst(list));
        System.out.println(ListUtils.getLast(ints));



//вернуть getHead(get first el), getlast; на входе лист<T> на выходе 1 или посл эл, если пустой то вернём Optional

//            System.out.println(ListUtils.foldLeft(ints, 0, Integer::sum)); //6
//            System.out.println(ListUtils.foldLeft(ints, 1, Integer::sum)); //7
////ВОЗВРАЩАЕМ INTEGER
//            System.out.println(ListUtils.foldLeft(ints, "", (acc, x) -> acc + x.toString())); //123


    }
}
