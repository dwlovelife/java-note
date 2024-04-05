package leetcode.top;

import java.util.Arrays;

public class Top96_136 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        singleNumber(arr);
    }

    public static int singleNumber(int[] nums) {
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
                    preEle = -1;
                } else {
                    return preEle;
                }
            }
        }
        return preEle;
    }

}
