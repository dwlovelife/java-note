package leetcode.arr;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class LeetCode1014 {

    public static void main(String[] args) {
        int[] tour = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair2(tour));
    }

    /**
     * 方法1: 暴力破解
     */
    private static int maxScoreSightseeingPair1(int[] A) {
        int sighting = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int result = A[i] + A[j] + i - j;
                sighting = Math.max(sighting, result);
            }
        }
        return sighting;
    }

    /**
     * 方法2: 动态规划
     */
    private static int maxScoreSightseeingPair2(int[] A) {
        int max = 0;
        int preMax = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, preMax + A[i] - i);
            preMax = Math.max(preMax,A[i] + i);
        }
        return max;
    }

}
