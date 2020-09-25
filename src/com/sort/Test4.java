package com.sort;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 荷兰国旗包含三种颜色：红、白、蓝。
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 题目描述：只有 0/1/2 三种颜色。
 */
public class Test4 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 1, 2, 1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortColors(int[] arr) {
        int zero = -1, one = 0, two = arr.length;
        while (one < two) {
            if (arr[one] == 2) {
                swat(arr, --two, one);
            } else if (arr[one] == 0) {
                swat(arr, ++zero, one++);
            } else {
                one++;
            }
        }
    }

    private static void swat(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

}
