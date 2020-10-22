package leetcode.level.easy;


import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class MyCode27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement2(nums, 3);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement1(int[] nums, int val) {
        int i = Integer.MAX_VALUE;
        int total = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                i = Math.min(i, j);
            } else {
                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i = j - i > 1 ? i + 1 : j;
                }
                total++;
            }
        }
        return total;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
