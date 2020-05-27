package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class LeetCode974 {
    public static void main(String[] args) {
        int[] A = {5, 5};
        int K = 5;
        int result = subarraysDivByK(A, 5);
        System.out.println(result);
    }

    private static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0,sum = 0;
        for (int a : A) {
            sum += a;
            int mold = (sum % K + K) % K;
            int result = map.getOrDefault(mold,0);
            ans += result;
            map.put(mold, result + 1);
        }
        return ans;
    }
}
