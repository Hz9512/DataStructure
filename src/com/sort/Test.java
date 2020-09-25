package com.sort;

import java.util.*;

/**
 * 1. 出现频率最多的 k 个元素
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
 *
 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class Test {
    public static void main(String[] args) {
        int []nums={1,1,1,2,2,3};
        List<Integer> integers = new Test().topKFrequent(nums, 2);
        System.out.println(integers);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        //这里的数组初始化长度为什么是nums.length + 1：如果说原数组里面的数组都是一样的，那么频率就是length,然而在下面频率需要作为中间数组下标，所以需要初始化长度为length+1
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            //值为频率，键为对应的数值
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        //为什么从后开始遍历，因为数组下标表示频率，后面的就表示频率大的先开始遍历
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            //目标数组的长度不能超过了k值
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

}
