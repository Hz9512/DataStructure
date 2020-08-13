package com.suanfa;

import java.util.Arrays;

public class Select {
    public static void selectSort(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int r = arr[i];
        arr[i] = arr[j];
        arr[j] = r;
    }

    public static void main(String[] args) {
        int []arr={43,24,32,434,3,5,4,321};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
