package leetcode.arr;

/**
 * 二分查找
 */
public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        int result = findIndex(nums, 2);
        System.out.println(result);
    }

//    public int[] searchRange(int[] nums, int target) {
//
//    }


    public static int findIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

}
