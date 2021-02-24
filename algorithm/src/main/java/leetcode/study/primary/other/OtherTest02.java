package leetcode.study.primary.other;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231
 */
public class OtherTest02 {
    public static void main(String[] args) {

    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (x & 1) == (y & 1) ? 0 : 1;
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

}
