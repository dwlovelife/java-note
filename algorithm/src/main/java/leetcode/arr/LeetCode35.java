package leetcode.arr;

/**
 * 二分查找
 */
public class LeetCode35 {
    public static void main(String[] args) {

    }


    public int searchInsert(int[] nums, int target) {
       int left = 0, right = nums.length - 1;
       while (left <= right) {
           int middle = left + ((right - left) / 2);
           if (nums[middle] > target) {
               right = middle - 1;
           } else if (nums[middle] < target) {
               left = middle + 1;
           } else {
               return middle;
           }
       }
       return left;
    }

}
