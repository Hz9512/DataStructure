package com.sort;

import java.util.Arrays;

/**
 * 快排
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int index = getIndex(arr, l, r);
            quickSort(arr, index + 1, r);
            quickSort(arr, l, index - 1);
        }
    }

    private static int getIndex(int[] arr, int l, int r) {
        int tem = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tem) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= tem) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = tem;
        return l;
    }
}
