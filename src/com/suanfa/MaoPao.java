package com.suanfa;

import java.util.Arrays;

public class MaoPao {
    public static void bubble(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={2, 4, 7, 6, 8, 5, 9};
        MaoPao maoPao=new MaoPao();
        maoPao.bubble(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr));
    }
}

