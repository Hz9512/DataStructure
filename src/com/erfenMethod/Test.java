package com.erfenMethod;

/**
 * 时间复杂度
 *
 * 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int i = binarySearch(arr, 5);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int key) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = 1 + (h - 1) / 2;
            if (arr[m] == key) {
                return m;
            } else if (arr[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
