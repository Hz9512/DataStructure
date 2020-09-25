package com.tanxin;

/**
 * 非递减就是baidua[i]<=a[i+1]
 * 递减就是a[i]>a[i+1]
 * 非递增就是a[i]>=a[i+1]
 * 递增就是a[i]<a[i+1]
 * <p>
 * 修改一个数成为非递减数组
 * 题目描述：判断一个数组是否能只修改一个数就成为非递减数组。
 * 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。
 * 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
 * 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，只能修改 nums[i] = nums[i - 1]。
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 */
public class Test9 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 0};
        boolean b = checkPossibility(arr);
        System.out.println(b);
    }

    public static boolean checkPossibility(int[] nums) {
        int cut = 0;
        for (int i = 1; i < nums.length && cut < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cut++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cut <= 1;
    }
}
