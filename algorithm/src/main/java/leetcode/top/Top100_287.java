package leetcode.top;

import java.util.Arrays;

public class Top100_287 {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int preEle = -1;
        for (int i = 0; i < nums.length; i++) {
            if (preEle == -1) {
                preEle = nums[i];
            } else {
                if (nums[i] == preEle) {
                    return preEle;
                } else {
                    preEle = nums[i];
                }
            }
        }
        return preEle;
    }

}
