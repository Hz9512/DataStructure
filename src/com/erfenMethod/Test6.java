package com.erfenMethod;

import java.util.Arrays;

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10, 11};
        int[] ints = searchRange(arr, 8);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirst(nums, target);
        int lastIndex = findFirst(nums, target + 1);
        if (firstIndex == nums.length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{firstIndex, Math.max(firstIndex, lastIndex)};
        }
    }

    private static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
