package leetcode.study.primary.arr;


import java.util.Arrays;

public class ArrTest08 {
    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
    }

}
