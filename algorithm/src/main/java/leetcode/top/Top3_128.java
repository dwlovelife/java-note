package leetcode.top;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 最长连续序列
 * @author: dingwei17@jd.com
 * @date : 2024/3/5 12:21
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
