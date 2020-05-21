package leetcode.arr;

/**
 * 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 */
public class LeetCode1010 {
    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        int[] time1 = {60, 60, 60};
        int total = numPairsDivisibleBy60(time);
        System.out.println(total);
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int total = 0;
        for (int t : time) {
            int remainder = t % 60;
            total += arr[remainder];
            int difference = remainder == 0 ? 0: 60 - remainder;
            arr[difference]++;
        }
        return total;
    }

}
