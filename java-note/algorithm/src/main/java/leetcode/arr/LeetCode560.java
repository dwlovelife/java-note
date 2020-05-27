package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析：前缀和问题 对于任何一个子数组 P(i) = i0+i1+i2+..+in 可得 sum(i,j) = p(j) - p(i - 1)
 * 那么子数组所加和为2,可理解为 p(j) - p(i - 1) = 2可得 p(j) = p(i - 1) + 2
 * <p>
 * 题：和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class LeetCode560 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int ans = subarraySum(arr, 3);
        System.out.println(ans);
    }

    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            int key = sum - k;
            if(map.containsKey(key)){
                count += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }

}
