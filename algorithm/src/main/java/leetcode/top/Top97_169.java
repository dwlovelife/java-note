package leetcode.top;

import java.util.Arrays;

public class Top97_169 {
    public static void main(String[] args) {
        int[] temp = {3, 2, 3};
        majorityElement(temp);
    }


    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        Integer preEle = null;
        int count = 0;
        int maxCount = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        for (int i = 0 ; i < nums.length; i++) {
            if (preEle == null) {
                preEle = nums[i];
                count++;
            } else {
                if (nums[i] == preEle) {
                    count++;
                    if (count >= maxCount) {
                        return preEle;
                    }
                } else {
                    if (count >= maxCount) {
                        return preEle;
                    }
                    preEle = null;
                    count = 0;
                }
            }
        }
        return -1;
    }

}
