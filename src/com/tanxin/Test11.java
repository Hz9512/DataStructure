package com.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integers = partitionLabels(s);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexsOfChar = new int[26];
        //将每个字符遍历出来，用该字符与‘a’的差值作为数组下标存入该字符的最大索引值
        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[getCharIndex(S.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            //遍历字符串，以字符最大索引为界限，在这个范围内找到比之更大的索引值，若找不到则断开遍历，开始下一组遍历
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexsOfChar[getCharIndex(S.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            //将每组的字符个数存入List
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private static int getCharIndex(char c) {
        return c - 'a';
    }
}
