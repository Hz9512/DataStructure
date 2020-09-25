package com.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按照字符出现次数对字符串排序
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class Test3 {
    public static void main(String[] args) {
        String tree = frequencySort("tree");
        System.out.println(tree);
    }

    public static String frequencySort(String s) {
        //第一步：存入map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //第二步：从map中取出存入list
        List<Character>[] lists = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            int f = map.get(c);
            if (lists[f] == null) {
                lists[f] = new ArrayList<>();
            }
            lists[f].add(c);
        }
        //第三步：从list中取出存入StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null) {
                continue;
            }
            for (char c : lists[i]) {
                for (int j = 0; j < i; j++) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }


}
