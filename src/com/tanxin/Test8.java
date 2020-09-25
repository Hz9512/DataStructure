package com.tanxin;

/**
 * 判断是否为子序列
 * s = "abc", t = "ahbgdc"
 * Return true.
 */
public class Test8 {
    public static void main(String[] args) {
        String str = "ahbgdc";
        String s = "abcs";
        boolean subsequence = isSubsequence(s, str);
        System.out.println(subsequence);

    }

    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
