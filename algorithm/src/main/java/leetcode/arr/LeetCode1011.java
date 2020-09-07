package leetcode.arr;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 *
 */
public class LeetCode1011 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = shipWithinDays(weights, 5);
        System.out.println(result);
    }

    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int min = 0;
        for (int weight : weights) {
            max += weight;
            min = Math.max(weight, min);
        }
        while (min < max) {
            int mid = (max + min) / 2; //2,3,4 2+4/2=3 所以不可能中间会漏掉某些数
            if (isTransfer(weights, mid, D)) {
                max = mid; //符合可以把右边全砍了
            } else {
                min = mid + 1; //不符合最小值向前进一位
            }
        }
        return min;
    }

    private static boolean isTransfer(int[] weights, int tryWeight, int D) {
        int counter = 0;
        for (int weight : weights) {
            counter += weight;
            if (counter > tryWeight) {
                D--;
                counter = weight;
            }
        }
        return D > 0;
    }

}
