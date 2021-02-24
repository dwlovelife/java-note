package leetcode.study.primary.other;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class OtherTest01 {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001111;
        System.out.println(hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            count += (n & mask) == 1 ? 1 : 0;
            n >>= 1;
        }
        return count;
    }

}
