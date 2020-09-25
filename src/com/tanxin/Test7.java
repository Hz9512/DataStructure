package com.tanxin;

/**
 * 种植花朵
 * 题目描述：flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 */
public class Test7 {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 0, 1, 0, 0};
        boolean b = canPlaceFlowers(arr, 2);
        System.out.println(b);
    }
    //两边的数都是0，中间的数置为1
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cut = 0;
        for (int i = 0; i < flowerbed.length && cut < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            //如果遍历的是第一个数，那么pre直接就置为0
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            //如果遍历的是最后一个数，那么next直接置为0
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cut++;
                flowerbed[i] = 1;
            }
        }
        return cut >= n;
    }
}
