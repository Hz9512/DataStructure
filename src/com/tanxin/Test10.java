package com.tanxin;

/**
 * 子数组最大的和
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * 算法描述：
 *
 * 遍历该数组， 在遍历过程中， 将遍历到的元素依次累加起来， 当累加结果小于或等于0时， 从下一个元素开始，重新开始累加。
 * 累加过程中， 要用一个变量(max_so_far)记录所获得过的最大值。
 * 一次遍历之后， 变量 max_so_far 中存储的即为最大子片段的和值。
 *
 * 理解此算法的关键在于:
 *
 * 最大子片段中不可能包含求和值为负的前缀。 例如 【-2， 1，4】 必然不能是最大子数列， 因为去掉值为负的前缀后【-2，1】， 可以得到一个更大的子数列 【4】、
 * 所以在遍历过程中，每当累加结果成为一个非正值时， 就应当将下一个元素作为潜在最大子数列的起始元素， 重新开始累加。
 * 由于在累加过程中， 出现过的最大值都会被记录， 且每一个可能成为 最大子数列起始元素 的位置， 都会导致新一轮的累加， 这样就保证了答案搜索过程的完备性和正确性。
 */
public class Test10 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];//开始遍历的总和
        int maxSum = preSum;//总和最大值
        for (int i = 0; i < nums.length; i++) {
            //如果总和小于或等于0了，就从下一个开始遍历
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }
}
