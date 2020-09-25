package com.tanxin;

/**
 * 买卖股票最大的收益
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *
 * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
 *
 */
public class Test5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = maxProfit(arr);
        System.out.println(i);
    }

    public static int maxProfit(int[] price) {
        if (price.length == 0) {
            return 0;
        }
        int sortPrice = price[0];
        int max = 0;
        for (int i = 0; i < price.length; i++) {
            if (sortPrice > price[i]) {
                sortPrice = price[i];
            } else {
                max = Math.max(max, price[i] - sortPrice);
            }
        }
        return max;
    }
}
