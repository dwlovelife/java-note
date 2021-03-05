package leetcode.level.medium;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class MyCode11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxValue = maxArea(arr);
        System.out.println(maxValue);
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 1) return 0;
        int maxValue = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            int leftValue = height[l];
            int rightValue = height[r];
            boolean flag = leftValue <= rightValue;
            if(flag){
                maxValue = Math.max(maxValue,(r - l) * leftValue);
                l++;
            }else{
                maxValue = Math.max(maxValue,(r - l) * rightValue);
                r--;
            }
        }
        return maxValue;
    }
}
