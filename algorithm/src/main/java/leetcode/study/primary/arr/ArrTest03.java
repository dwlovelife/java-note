package leetcode.study.primary.arr;

import java.util.Arrays;

/**
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * LC旋转数组
 */
public class ArrTest03 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 类似环形队列取余的技巧
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int rotateNum = length - (k % length);
        if (rotateNum == length) return;
        int[] result = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            int index = (i + rotateNum)  % (length);
            nums[i] = result[index];
        }
    }

}
