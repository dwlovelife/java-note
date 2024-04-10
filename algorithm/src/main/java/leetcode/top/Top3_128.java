package leetcode.top;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Top3_128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int maxLongCount = 0;
        for (Integer num: nums) {
            //说明num是最小的数
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum = currentNum + 1)) {
                    count++;
                }
                maxLongCount = Math.max(maxLongCount, count);
            }
        }
        return maxLongCount;
    }
}
