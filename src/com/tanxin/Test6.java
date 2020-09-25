package com.tanxin;

/**
 * 买卖股票的最大收益 II
 * 题目描述：可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 *
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a) ，
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
public class Test6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    public static int maxProfit(int[] price) {
        if (price.length == 0) {
            return 0;
        }
        int shouyi = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                shouyi += price[i] - price[i - 1];
            }
        }
        return shouyi;
    }
}
