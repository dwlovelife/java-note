package leetcode.level.easy;


public class MyCode35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
    }


    public int searchInsert(int[] nums, int target) {
        int result = -1;
        if(target < nums[0]){
            return 0;
        }else if(target > nums[nums.length - 1]){
            return nums.length;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return result;
    }
}
