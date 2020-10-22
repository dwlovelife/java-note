package leetcode.level.easy;

import java.util.Arrays;

/**
 * 0 1 1 2 2
 * 删除排序数组的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素
 */
public class MyCode26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 此算法 其实无序也可以 但必须保证重复元素都在一起 这样就能达到 前面的元素都是有序
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //i是慢指针 j是快指针
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //i是 下标 长度要加1
        return i + 1;
    }
}
