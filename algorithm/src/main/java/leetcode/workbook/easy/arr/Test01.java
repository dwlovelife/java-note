package leetcode.workbook.easy.arr;

import java.util.Arrays;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 0 0 1 1 2 4
 * 0 1 1 2 3
 */
public class Test01 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2 , 2, 4};
        int count = removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int count = 1;
        int compare = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != compare) {
                nums[count] = nums[i];
                compare = nums[count];
                count++;
            }
        }
        return count;
    }

}
