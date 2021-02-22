package leetcode.study.primary.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 */
public class MathTest03 {
    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree2(n));
    }

    public static boolean isPowerOfThree1(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        double d = Math.log(n) / Math.log(3);
        long i = Math.round(d);
        //因为有精度损失的问题，1e-10代表 1*10的负10次方 由于 精度损失会变成5.00000000...1 所以是无穷小 自然比 1e-10要小
        return Math.abs(d - i) < 1e-10;//差不多就行了
    }

}
