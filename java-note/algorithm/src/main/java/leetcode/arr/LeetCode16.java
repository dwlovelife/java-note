package leetcode.arr;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int result = threeSumClosest(nums,-5);
        System.out.println(result);
    }

    public static int threeSumClosest(int[] nums, int target) {

        int len = nums.length;
        if (len < 3) {
            throw new RuntimeException("输入参数不正确");
        }
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                int min = Math.min(Math.abs(sum - target), minDistance);
                if(min != minDistance){
                    value = sum;
                    minDistance = min;
                }
                if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return value;
    }

}
