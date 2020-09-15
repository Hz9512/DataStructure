package com.twopoint;

import java.util.Arrays;

/**
 * 1. 有序数组的 Two Sum
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * <p>
 * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * <p>
 * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
 * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {4, 25, 43, 6, 5473, 423, 4, 26, 543432, 4, 64, 54, 5};
        sortArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] ints = toSum(arr, 118);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] toSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void sortArray(int[] arr) {
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
}
