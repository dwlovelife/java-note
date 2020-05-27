package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class LeetCode287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int result = findDuplicate1(nums);
        System.out.println(result);
    }

    /**
     * 没想到这种方法很low逼,只超过了百分之10几的人,但是好歹很短时间给AC出来了
     */
    private static int findDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        throw new RuntimeException("未找到该重复数字");
    }

}
