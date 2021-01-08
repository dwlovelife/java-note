package leetcode.study.primary.arr;


import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 */
public class ArrTest06 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int count = container.getOrDefault(nums1[i], 0) + 1;
            container.put(nums1[i], count);
        }
        int[] intersect = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            Integer result = container.get(nums2[i]);
            if (result != null) {
                intersect[index++] = nums2[i];
                result = result - 1;
                if (result == 0) {
                    container.remove(nums2[i]);
                } else {
                    container.put(nums2[i],result) ;
                }
            }
        }
        return Arrays.copyOfRange(intersect, 0 , index);
    }



}
