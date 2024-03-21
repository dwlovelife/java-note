package leetcode.top;


/**
 * @description: 测试模版
 * @author: dingwei17@jd.com
 * @date : 2024/3/21 15:32
 */
public class Test {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            if (leftValue < rightValue) {
                maxArea = Math.max(maxArea, leftValue * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, rightValue * (right - left));
                right--;
            }
        }
        return maxArea;
    }
}

