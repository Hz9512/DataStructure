package com.test;

import java.util.*;

public class CollectionDemoTest {
    public static void main(String[] args) {
//        HashMap map = new HashMap();
//        map.put("1", "asd");
        ArrayList<Integer> list = new ArrayList(21);
        list.add(111);

        for (int i : list) {
            System.out.println(i);
        }
    }
}
